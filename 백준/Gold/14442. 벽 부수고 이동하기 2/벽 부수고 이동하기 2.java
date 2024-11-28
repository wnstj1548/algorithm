import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int graph[][][];
    static boolean visited[][][];
    static int n,m,k;
    static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    static int bfs() {

        for(int i = 0; i<=k; i++) {
            graph[i][0][0] = 1;
        }

        visited[0][0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowK = now[0];
            int nowX = now[1];
            int nowY = now[2];

            if(nowX == n-1 && nowY == m-1) {
                return graph[nowK][nowX][nowY];
            }

            for(int i = 0; i<4; i++) {

                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];
                int nk = nowK + 1;

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {

                    if(nk <= k && graph[nowK][nx][ny] == -1 && !visited[nk][nx][ny]) {
                        graph[nk][nx][ny] = graph[nowK][nowX][nowY] + 1;
                        visited[nk][nx][ny] = true;
                        queue.add(new int[]{nk, nx, ny});
                    }

                    if(graph[nowK][nx][ny] == 0 && !visited[nowK][nx][ny]) {
                        graph[nowK][nx][ny] = graph[nowK][nowX][nowY] + 1;
                        visited[nowK][nx][ny] = true;
                        queue.add(new int[]{nowK, nx, ny});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[k+1][n][m];
        visited = new boolean[k+1][n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == '1') {
                    for(int h = 0; h <= k; h++) {
                        graph[h][i][j] = -1;
                    }
                }
            }
        }

        int result = bfs();

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}