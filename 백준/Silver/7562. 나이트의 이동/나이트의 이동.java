import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int endX, endY, size, count;
    static int[][] pos = {{1,-2}, {1,2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};

    public static int bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {

            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            if(nowX == endX && nowY == endY) {
                break;
            }

            for(int j=0; j<8; j++) {
                int nx = nowX + pos[j][0];
                int ny = nowY + pos[j][1];

                if (nx >= 0 && nx < size && ny >= 0 && ny < size && !visited[nx][ny]) {
                    graph[nx][ny] = graph[nowX][nowY] + 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return graph[endX][endY];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            size = Integer.parseInt(br.readLine());

            graph = new int[size][size];
            visited = new boolean[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            int result = bfs(x,y);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}