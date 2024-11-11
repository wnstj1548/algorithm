import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for (int i = 0; i < pos.length; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    graph[nx][ny] = 1 + graph[nowX][nowY];
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                graph[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        bw.write(graph[n-1][m-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}