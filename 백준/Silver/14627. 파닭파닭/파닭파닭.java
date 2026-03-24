import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int s, c;
    static long[] pa;
    static long res = Long.MAX_VALUE;

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static long nextLong() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }

    public static void main(String[] args) throws Exception {

        s = nextInt();
        c = nextInt();

        pa = new long[s];
        long left = 1;
        long right = 0;

        for(int i = 0; i < s; i++) {
            long temp = nextLong();
            pa[i] = temp;
            right = Math.max(right, temp);
        }

        while(left <= right) {
            long mid = (left + right) / 2;
            long tempSum = 0;
            long sum = 0;

            for(int i = 0; i < s; i++) {
                long cnt = pa[i] / mid;
                tempSum += pa[i] % mid;
                sum += cnt;
            }

            if(sum >= c) {
                left = mid + 1;
                res = tempSum + ((sum -c) * mid);
            } else {
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}