import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 1000001; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }

        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            bw.write(dp[temp] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}