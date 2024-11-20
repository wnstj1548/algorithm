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
        int[] result = new int[n+2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            moneys[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            result[i] = Math.max(result[i], result[i-1]);

            if(days[i] + i -1 <= n) {
                result[i+ days[i]] = Math.max(result[i+days[i]], result[i] + moneys[i]);
            }
        }

        Arrays.sort(result);

        bw.write(result[n+1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}