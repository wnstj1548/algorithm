import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, r, q;
    static List<Integer>[] trees;
    static int[] dp;

    static int go(int idx, int parent) {

        int ret = 1;

        if(dp[idx] != -1) return dp[idx];

        List<Integer> next = trees[idx];

        for(int n : next) {
            if(parent == n) continue;
            ret += go(n, idx);
        }

        dp[idx] = ret;

        return dp[idx];
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        r = nextInt();
        q = nextInt();

        trees = new List[n+1];
        dp = new int[n+1];

        Arrays.fill(dp, -1);

        for(int i = 0; i < n+1; i++) {
            trees[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            int u = nextInt();
            int v = nextInt();

            trees[u].add(v);
            trees[v].add(u);
        }

        int ret = go(r, 0);

        for(int i = 0; i < q; i++) {
            int temp = nextInt();
            bw.write(String.valueOf(dp[temp]));
            bw.newLine();
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