import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] pos = {{1,0}, {0,1}};
    static int[][] arr;
    static int n;
    static boolean[][] visited;

    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        visited[1][1] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int k = arr[nowX][nowY];

            if(nowX == n && nowY ==n) {
                return true;
            }

            for(int i = 0; i < 2; i++) {
                int nx = nowX + pos[i][0] * k;
                int ny = nowY + pos[i][1] * k;

                if(nx > 0 && nx <= n && ny > 0 && ny <= n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(bfs()) {
            bw.write("HaruHaru\n");
        } else {
            bw.write("Hing\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
