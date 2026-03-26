import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, m;
    static char[][] a;
    static int[][] dp;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    static boolean isCycle = false;

    public static int dp(int nowY, int nowX) {

        if(nowY < 0 || nowX < 0 || nowX >= m || nowY >= n || a[nowY][nowX] == 'H') {
            return 0;
        }

        if(visited[nowY][nowX]) {
            isCycle = true;
            return 0;
        }

        if(dp[nowY][nowX] != -1) return dp[nowY][nowX];
        visited[nowY][nowX] = true;

        int multi = a[nowY][nowX] - '0';
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < 4; i++) {
            int ny = nowY + dy[i] * multi;
            int nx = nowX + dx[i] * multi;
            max = Math.max(max, dp(ny, nx));

            if(isCycle) {
                visited[nowY][nowX] = false;
                return 0;
            }
        }

        visited[nowY][nowX] = false;
        dp[nowY][nowX] = max + 1;

        return dp[nowY][nowX];
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        m = nextInt();

        a = new char[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        int ret = Integer.MIN_VALUE;

        ret = Math.max(ret, dp(0, 0));

        bw.write(isCycle ? "-1" : String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    private static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static long nextLong() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }
}