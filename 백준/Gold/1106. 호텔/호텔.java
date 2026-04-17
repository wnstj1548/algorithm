import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int c, n;
    static int[] cost;
    static int[] people;
    static int[] dp;

    static int INF = 987654321;

    public static void main(String[] args) throws Exception {

        c = nextInt();
        n = nextInt();

        cost = new int[n];
        people = new int[n];
        dp = new int[c+101];

        for(int i = 0; i < n; i++) {
            cost[i] = nextInt();
            people[i] = nextInt();
        }

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = people[i]; j <= c + 100; j++) {
                dp[j] = Math.min(dp[j], dp[j - people[i]] + cost[i]);
            }
        }

        int ret = INF;

        for(int i = c; i < c + 101; i++) {
            ret = Math.min(ret, dp[i]);
        }

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