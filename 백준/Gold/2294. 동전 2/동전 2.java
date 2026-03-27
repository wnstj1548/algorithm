import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, k;
    static int[] dp;
    static int INF = 987654321;
    static int[] coin;

    static int go(int num) {

        if(num == 0) return 0;
        if(dp[num] != -1) return dp[num];

        int min = INF;

        for(int i = 0; i < n; i++) {
            if(coin[i] <= num) {
                int prev = go(num - coin[i]);
                if(prev != INF) {
                    min = Math.min(min, prev + 1);
                }
            }
        }

        dp[num] = min;
        return dp[num];
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        k = nextInt();
        coin = new int[n];
        dp = new int[k+1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            coin[i] = nextInt();
        }

        int ret = go(k);

        bw.write(ret != INF ? String.valueOf(ret) : "-1");
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