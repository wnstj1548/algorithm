import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][][] dp = new int[5][5][100001];
    static List<Integer> l = new ArrayList<>();

    static int go(int y, int x, int target) {
        if(target == l.size()) return 0;
        if(dp[y][x][target] != -1) return dp[y][x][target];

        int left = go(l.get(target), x, target+1) + check(y, l.get(target));
        int right = go(y, l.get(target), target+1) + check(x, l.get(target));
        dp[y][x][target] = Math.min(left, right);

        return dp[y][x][target];
    }

    static int check(int from, int to) {
        if(from == 0) return 2;
        if(from == to) return 1;
        if(Math.abs(from - to) == 2) return 4;
        return 3;
    }

    public static void main(String[] args) throws Exception {

        int num;

        while((num = nextInt()) != 0) {
            l.add(num);
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int res = go(0, 0, 0);

        bw.write(String.valueOf(res));
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