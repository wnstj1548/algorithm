import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] a = new int[2001];
    static int[][] dp = new int[2001][2001];
    static int n, m;

    public static void main(String[] args) throws Exception {

        n = nextInt();

        for(int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }

        for(int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            if(a[i] == a[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        for(int size = 2; size <= n; size++) {
            for(int i = 1; i <= n-size; i++) {
                if(a[i] == a[i+size] && dp[i+1][i + size - 1] == 1) {
                    dp[i][i+size] = 1;
                }
            }
        }

        m = nextInt();

        for(int i = 0; i < m; i++) {
            int s = nextInt();
            int e = nextInt();

            bw.write(dp[s][e] + "\n");
        }

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