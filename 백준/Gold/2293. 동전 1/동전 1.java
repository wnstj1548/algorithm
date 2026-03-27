import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, k;
    static int[][] dp;
    static int INF = 987654321;
    static int[] coin;

    static int go(int idx, int sum) {

        if(sum == 0) return 1;
        if(idx == n) return 0;
        if(dp[idx][sum] != -1) return dp[idx][sum];

        int res = 0;

        for(int i = 0; i <= sum; i += coin[idx]) {
            res += go(idx + 1, sum - i);
        }
        
        dp[idx][sum] = res;
        return dp[idx][sum];
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        k = nextInt();

        coin = new int[n];
        dp = new int[n][k+1];

        for(int i = 0; i < n; i++) {
            coin[i] = nextInt();
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ret = go(0, k);

        bw.write(String.valueOf(ret));
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