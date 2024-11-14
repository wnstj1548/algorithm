import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] graph;
    static boolean[][] visited;
    static int a, b;
    static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> fireQueue = new LinkedList<>();
        boolean[][] visited = new boolean[b][a];
        int count = 0;

        for(int j = 0; j < b; j++) {
            for(int k = 0; k < a; k++) {
                if(graph[j][k] == '*') {
                    fireQueue.add(new int[]{j, k});
                } else if(graph[j][k] == '@') {
                    queue.add(new int[]{j, k});
                    graph[j][k] = '.';
                }
            }
        }

        while(!queue.isEmpty()) {

            int fireSize = fireQueue.size();
            count++;

            for (int i = 0; i < fireSize; i++) {

                int[] arr = fireQueue.poll();
                int nowX = arr[0];
                int nowY = arr[1];

                for (int j = 0; j < 4; j++) {
                    int nx = nowX + pos[j][0];
                    int ny = nowY + pos[j][1];

                    if (graph[nowX][nowY] == '*' && nx >= 0 && nx < b && ny >= 0 && ny < a && graph[nx][ny] == '.') {
                        graph[nx][ny] = '*';
                        fireQueue.add(new int[]{nx, ny});
                    }
                }
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] arr = queue.poll();
                int nowX = arr[0];
                int nowY = arr[1];

                if (nowX == b - 1 || nowX == 0 || nowY == 0 || nowY == a - 1) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = nowX + pos[j][0];
                    int ny = nowY + pos[j][1];

                    if (nx >= 0 && nx < b && ny >= 0 && ny < a && !visited[nx][ny] && graph[nx][ny] == '.') {
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

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph = new char[b][a];

            for(int j = 0; j < b; j++) {
                String s = br.readLine();
                for(int k = 0; k < a; k++) {
                    graph[j][k] = s.charAt(k);
                }
            }

            int result = bfs();
            bw.write(result == -1 ? "IMPOSSIBLE\n" : result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}