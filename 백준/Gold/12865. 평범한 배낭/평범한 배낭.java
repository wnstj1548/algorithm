import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[i][0] = weight;
            arr[i][1] = value;
        }

        int[] dp = new int[maxWeight + 1];

        for(int i = 0; i<n; i++) {
            int weight = arr[i][0];
            int value = arr[i][1];

            for(int j = maxWeight; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }

        bw.write(dp[maxWeight] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}