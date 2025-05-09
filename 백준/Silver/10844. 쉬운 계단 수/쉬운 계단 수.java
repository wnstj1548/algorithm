import java.io.*;

class Main {

    final static long MOD = 1000000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];

        for(int i = 1; i < 10; i++) { 
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j==0) {
                    dp[i][0] = dp[i-1][1] % MOD;
                } else if (j == 9) {
                    dp[i][9] = dp[i-1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                }
            }
        }

        long result = 0;

        for(int i = 0; i < 10; i++) {
            result += dp[n][i];
        }

        bw.write(result % MOD + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}