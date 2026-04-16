import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static final int INF = 987654321;

    static int[][] dp = new int[2501][2501];
    static int[] dp2 = new int[2501];

    static String s;

    static int go(int here) {
        if(here == s.length()) return 0;
        if(dp2[here] != INF) return dp2[here];

        int ret = INF;

        for(int len = 1; here <= s.length() - len; len++) {
            if(dp[here][len] == 1) {
                ret = Math.min(ret, go(here + len) + 1);
            }
        }

        dp2[here] = ret;

        return ret;
    }

    public static void main(String[] args) throws Exception {

        s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            dp[i][1] = 1;
        }

        for(int i = 0; i < s.length() -1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][2] = 1;
            }
        }

        for(int size = 3; size <= s.length(); size++) {
            for(int i = 0; i <= s.length() - size; i++) {
                if(s.charAt(i) == s.charAt(i+size-1) && dp[i+1][size-2] == 1) {
                    dp[i][size] = 1;
                }
            }
        }

        Arrays.fill(dp2, INF);

        int ret = go(0);

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}