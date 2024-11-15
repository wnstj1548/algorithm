import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static int n;
    static boolean[][] visited;
    static int[][] pos = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void bfs(int x, int y, int h) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] > h && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        int maxHeight = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        int maxZone = 0;

        for(int k = 0; k <= maxHeight; k++) {

            int count = 0;
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && graph[i][j] > k) {
                        bfs(i, j, k);
                        count++;
                    }
                }
            }

            maxZone = Math.max(maxZone, count);
        }

        bw.write(maxZone + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}