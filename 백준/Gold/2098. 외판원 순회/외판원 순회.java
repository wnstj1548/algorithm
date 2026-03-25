import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n;
    static int[][] dist;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE / 4;

    static int tsp(int here, int visited) {

        if(visited == (1 << n) -1) {
            return dist[here][0] == 0 ? INF : dist[here][0];
        }

        if(dp[here][visited] != -1) {
            return dp[here][visited];
        }

        int ret = INF;

        for(int next = 0; next < n; next++) {
            if((visited & (1 << next)) != 0) continue;
            if(dist[here][next] == 0) continue;
            ret = Math.min(ret, tsp(next, visited | (1 << next)) + dist[here][next]);
        }

        dp[here][visited] = ret;

        return ret;
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        dist = new int[n][n];
        dp = new int[n][1 << n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = nextInt();
            }
        }

        int result = tsp(0, 1);

        bw.write(String.valueOf(result));
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