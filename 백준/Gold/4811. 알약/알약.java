import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static long[][] dp = new long[31][62];

    public static long dp(int one, int half) {

        long res = 0;

        if(dp[one][half] != -1) {
            return dp[one][half];
        }

        if(one == 1 && half == 0) {
            return 1;
        } else if(one == 0 && half == 1) {
            return 1;
        }

        if(one >= 1) {
            res += dp(one -1, half + 1);
        }

        if(half >= 1) {
            res += dp(one, half -1);
        }

        dp[one][half] = res;

        return dp[one][half];
    }

    public static void main(String[] args) throws Exception {

        for(int i = 0 ; i < 31; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;

        int input;

        while((input = nextInt()) != 0) {
            long ret = dp(input, 0);
            bw.write(String.valueOf(ret));
            bw.newLine();
        }

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