import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, m, c;
    static int[][] a;
    static int[][][][] dp;
    private static final int MOD = 1000007;

    static int go(int y, int x, int cnt, int prev) {
        if (y > n || x > m || cnt < 0) return 0;

        if(y == n && x == m) {
            if(cnt == 0 && a[y][x] == 0) return 1;
            if(cnt == 1 && a[y][x] > prev) return 1;
            return 0;
        }

        if(dp[y][x][cnt][prev] != -1) return dp[y][x][cnt][prev];

        int ret = 0;

        if(a[y][x] == 0) {
            ret = (go(y+1, x, cnt, prev) + go(y, x+1, cnt, prev)) % MOD;
        } else if (prev < a[y][x]) {
            ret = (go(y+1, x, cnt -1, a[y][x]) + go(y, x+1, cnt-1, a[y][x])) % MOD;
        }

        dp[y][x][cnt][prev] = ret;
        return dp[y][x][cnt][prev];
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        m = nextInt();
        c = nextInt();

        a = new int[n+1][m+1];
        dp = new int[n+1][m+1][c+1][c+1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= c; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        for(int i = 1; i <= c; i++) {
            int y = nextInt();
            int x = nextInt();
            a[y][x] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= c; i++) {
            sb.append(go(1, 1, i, 0)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static double nextDouble() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Double.parseDouble(st.nextToken());
    }
}