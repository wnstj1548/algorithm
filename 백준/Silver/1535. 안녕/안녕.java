import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n;
    static int[] hp;
    static int[] joy;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        n = nextInt();
        hp = new int[n+1];
        joy = new int[n+1];
        dp = new int[101];
        visited = new boolean[n+1];

        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++) {
            hp[i] = nextInt();
            min = Math.min(min, hp[i]);
        }

        for(int i = 1; i <= n; i++) {
            joy[i] = nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 100; j > hp[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - hp[i]] + joy[i]);
            }
        }

        bw.write(String.valueOf(dp[100]));
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