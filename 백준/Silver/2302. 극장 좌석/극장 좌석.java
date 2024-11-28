import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        int sum = 1;

        List<Integer> fix = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            fix.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(fix);

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int last = 0;
        List<Integer> resultList = new ArrayList<>();

        for(int i : fix) {
            resultList.add(dp[i - last -1]);
            last = i;
        }

        resultList.add(dp[n - last]);

        for(int i : resultList) {
            sum *= i;
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}