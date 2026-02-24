import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] adj;
    static boolean[][] visited;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int height = 0;

    static void dfs(int y, int x) {

        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(visited[ny][nx] || adj[ny][nx] <= height) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) throws IOException {

        int maxCount = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        n = Integer.parseInt(br.readLine());
        int count = 0;
        adj = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if(adj[i][j] > maxHeight) maxHeight = adj[i][j];
            }
        }

        for(int k = 0; k < maxHeight; k++) {
            count = 0;
            for(int ii = 0; ii < n; ii++) {
                Arrays.fill(visited[ii], false);
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && adj[i][j] > height) {
                        count++;
                        dfs(i,j);
                    }
                }
            }
            if(count > maxCount) maxCount = count;
            height++;
        }

        bw.write(maxCount + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}