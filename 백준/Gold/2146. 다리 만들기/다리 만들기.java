import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[][] graph;
    static int index = 2;
    static boolean[][] indexVisited;
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void changeGraph(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            graph[nowX][nowY] = index;

            for(int i = 0; i < 4; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !indexVisited[nx][ny] && graph[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    indexVisited[nx][ny] = true;
                }
            }
        }
    }

    public static int calculateBridge(int x, int y, int index) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[n][n];
        for(int[] row : distance) Arrays.fill(row, -1);

        queue.add(new int[]{x, y});
        distance[x][y] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(graph[nx][ny] != 0 && graph[nx][ny] != index) {
                        return distance[nowX][nowY];
                    }
                    if(graph[nx][ny] == 0 && distance[nx][ny] == -1) {
                        queue.add(new int[]{nx, ny});
                        distance[nx][ny] = distance[nowX][nowY] + 1;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        indexVisited = new boolean[n][n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!indexVisited[i][j] && graph[i][j] == 1) {
                    changeGraph(i, j);
                    index++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + pos[k][0];
                        int ny = j + pos[k][1];

                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && graph[nx][ny] == 0) {
                            min = Math.min(min, calculateBridge(i, j, graph[i][j]));
                        }
                    }
                }
            }
        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}