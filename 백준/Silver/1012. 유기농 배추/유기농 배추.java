import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int n, m;

    public static void dfs(boolean[][] visited, int[][] adj, int y, int x) {

        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if(visited[ny][nx]) continue;
            if(adj[ny][nx] == 0) continue;
            visited[ny][nx] = true;
            dfs(visited, adj, ny, nx);
        }
    }

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] adj = new int[n][m];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj[y][x] = 1;
            }

            int count = 0;
            boolean[][] visited = new boolean[n][m];

            for(int ii = 0; ii < n; ii++) {
                for(int iii = 0; iii < m; iii++) {
                    if(adj[ii][iii] == 1 && !visited[ii][iii]) {
                        count++;
                        dfs(visited, adj, ii, iii);
                    }
                }
            }

            bw.write(count + "");
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();
    }
}