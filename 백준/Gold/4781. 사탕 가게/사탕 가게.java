import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static Candy[] candies;
    static int n;
    static int[] dp;

    static class Candy {
        int calories;
        int price;

        public Candy(int calories, int price) {
            this.calories = calories;
            this.price = price;
        }
    }

    static int go(int money) {

        for(int i = 0; i < n; i++) {
            for(int j = candies[i].price; j <= money; j++) {
                dp[j] = Math.max(dp[j], dp[j - candies[i].price] + candies[i].calories);
            }
        }

        return dp[money];
    }

    public static void main(String[] args) throws Exception {

        while((n = nextInt()) != 0) {

            candies = new Candy[n];
            int m = (int) Math.round(nextDouble() * 100);
            dp = new int[m+1];

            for(int i = 0; i < n; i++) {
                candies[i] = new Candy(nextInt(), (int) Math.round(nextDouble() * 100));
            }

            bw.write(String.valueOf(go(m)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static double nextDouble() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Double.parseDouble(st.nextToken());
    }
}