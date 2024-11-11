import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int count = 0;

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
                    count++;
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

        boolean zero = true;
        List<Integer> answer = new ArrayList<>();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    zero = false;
                }
            }
        }

        if (zero) {
            bw.write("0\n0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0;
                if (!visited[i][j] && graph[i][j] == 1) {
                    count++;
                    bfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        bw.write(answer.get(answer.size() - 1) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}