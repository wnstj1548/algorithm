import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] pos = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    static int[][] arr;
    static int n, m;

    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n+1][m+1];

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        arr[x][y] = -1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(arr[i][j] == -1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx > 0 && ny > 0 && nx <= n && ny <= m && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    arr[nx][ny] = -1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean melt() {

        boolean isChange = false;

        for(int i =1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(arr[i][j] == 1) {

                    int count = 0;

                    for(int k = 0; k < 4; k++) {
                        int nx = i + pos[k][0];
                        int ny = j + pos[k][1];

                        if(nx > 0 && ny > 0 && nx <= n && ny <= m && arr[nx][ny] == -1) {
                            count++;
                        }
                    }

                    if(count >= 2) {
                        arr[i][j] = -2;
                        isChange = true;
                    }
                }
            }
        }

        if(isChange) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    if(arr[i][j] == -2) {
                        arr[i][j] = -1;

                        for(int k = 0; k < 4; k++) {
                            int nx = i + pos[k][0];
                            int ny = j + pos[k][1];

                            if(nx > 0 && ny > 0 && nx <= n && ny <= m && arr[nx][ny] == 0) {
                                bfs(nx, ny);
                            }
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int result = 0;

        arr = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1,1);

        while(true) {
            if(!melt()) {
                break;
            }
            result++;
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
