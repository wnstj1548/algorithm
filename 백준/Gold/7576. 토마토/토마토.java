import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] graph;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int day = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean change = false;

            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int nowX = arr[0];
                int nowY = arr[1];

                for (int j = 0; j < pos.length; j++) {
                    int nx = nowX + pos[j][0];
                    int ny = nowY + pos[j][1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 0) {
                        graph[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                        change = true;
                    }
                }
            }

            if (change) day++; 
        }

        if (isZero(graph)) {
            return -1;
        }

        return day;
    }

    public static boolean isZero(int[][] graph) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}