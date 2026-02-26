import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] adj;
    static int day = 0;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static boolean[][] visited;

    public static void dfs(int y, int x) {

        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if(!visited[ny][nx] && adj[ny][nx] == 0) dfs(ny, nx);
            if(!visited[ny][nx] && adj[ny][nx] == 1) {
                adj[ny][nx] = 0;
                visited[ny][nx] = true;
            }
        }
    }

    public static boolean isZero() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(adj[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                adj[i][j] = temp;
            }
        }

        int count = 0;

        while(!isZero()) {
            day++;
            count = 0;
            for(int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            for(int i = 0; i < n ; i++) {
                for(int j = 0; j < m; j++) {
                    if(adj[i][j] == 1) count++;
                }
            }

            dfs(0,0);
        }

        bw.write(day + "");
        bw.newLine();
        bw.write(count + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}