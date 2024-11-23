import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        int n = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n-1; i >= 0; i--) {
            if(money >= coins[i]) {
                sum += money / coins[i];
                money = money % coins[i];
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}