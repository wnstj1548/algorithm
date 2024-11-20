import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] days = new int[n+1];
        int[] moneys = new int[n+1];
        int[] result = new int[n+1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            moneys[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            result[i] = moneys[i];
            if(days[i] + i -1 > n) {
                result[i] = 0;
            }

            for(int j =1; j <= i; j++) {
                if((days[i] + i -1) <= n && (days[j] + j) <= i) {
                    result[i] = Math.max(result[i], result[j] + moneys[i]);
                }
            }
        }

        Arrays.sort(result);

        bw.write(result[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}