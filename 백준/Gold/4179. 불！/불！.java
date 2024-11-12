import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] graph;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> fireQueue = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 'J') {
                    queue.add(new int[]{i, j});
                    graph[i][j] = '.';
                } else if(graph[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {

            int fireSize = fireQueue.size();
            count++;

            for(int i = 0; i<fireSize; i++) {
                int arr[] = fireQueue.poll();
                int nowX = arr[0];
                int nowY = arr[1];

                for(int j =0; j < 4; j++) {
                    int nx = nowX + pos[j][0];
                    int ny = nowY + pos[j][1];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == '.') {
                        graph[nx][ny] = 'F';
                        fireQueue.add(new int[]{nx, ny});
                    }
                }
            }

            int size = queue.size();

            for(int i = 0; i<size; i++) {
                int arr[] = queue.poll();
                int nowX = arr[0];
                int nowY = arr[1];

                if(nowX == 0 || nowX == n - 1 || nowY == 0 || nowY == m - 1) {
                    return count;
                }

                for(int j =0; j < 4; j++) {
                    int nx = nowX + pos[j][0];
                    int ny = nowY + pos[j][1];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            for(int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        int result = bfs();

        bw.write(result == -1 ? "IMPOSSIBLE" : result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}