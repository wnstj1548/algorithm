import java.io.*;
import java.util.*;

class Main {

    static int[][][] graph;
    static boolean[][][] visited;
    static int[][] normalPos = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static int[][] horsePos = {{2,1}, {-2,1}, {2, -1}, {-2,-1}, {1,2}, {-1,2}, {1,-2}, {-1,-2}};
    static int k, w, h;

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        graph[0][0][0] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowK = now[2];

            if(nowX == h-1 && nowY == w-1) {
                return graph[nowX][nowY][nowK];
            }

            if (k > nowK) {

                for(int i = 0; i < 8; i++) {
                    int nx = nowX + horsePos[i][0];
                    int ny = nowY + horsePos[i][1];
                    int nk = nowK + 1;

                    if(nx >= 0 && ny >=0 && nx < h && ny < w && graph[nx][ny][nk] != -1 && !visited[nx][ny][nk]) {
                        visited[nx][ny][nk] = true;
                        graph[nx][ny][nk] = graph[nowX][nowY][nowK] + 1;
                        queue.add(new int[]{nx, ny, nk});
                    }
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx = nowX + normalPos[i][0];
                int ny = nowY + normalPos[i][1];
                int nk = nowK;

                if(nx >= 0 && ny >=0 && nx < h && ny < w && graph[nx][ny][nk] != -1 && !visited[nx][ny][nk]) {
                    visited[nx][ny][nk] = true;
                    graph[nx][ny][nk] = graph[nowX][nowY][nowK] + 1;
                    queue.add(new int[]{nx, ny, nk});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[h][w][k+1];
        visited = new boolean[h][w][k+1];

        for (int i = 0; i < h; i++) {
            Arrays.fill(graph[i][0], Integer.MAX_VALUE);
        }

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    for (int a = 0; a <= k; a++) {
                        graph[i][j][a] = -1;
                    }
                }
            }
        }

        int min = bfs();

        bw.write( min + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}