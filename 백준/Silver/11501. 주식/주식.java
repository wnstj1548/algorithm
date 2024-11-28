import jdk.jfr.Unsigned;

import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {

            int m = Integer.parseInt(br.readLine());
            long[] greedy = new long[m];
            long sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                greedy[j] = Integer.parseInt(st.nextToken());
            }

            long max = Long.MIN_VALUE;
            for(int j = m-1; j >= 0; j--) {

                if(greedy[j] > max) {
                    max = greedy[j];
                } else {
                    sum += max - greedy[j];
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}