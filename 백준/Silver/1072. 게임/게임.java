import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static long x, y;
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

        x = nextLong();
        y = nextLong();

        long nowPercent = (y * 100 / x);

        long left = 1;
        long right = 1_000_000_000L;

        while(left <= right) {
            long mid = (left + right) / 2;

            long newPercent = ((y + mid) * 100) / (x + mid);

            if(nowPercent < newPercent) {
                right = mid - 1;
                res = Math.min(res, mid);
            } else {
                left = mid + 1;
            }
        }

        bw.write(res == Long.MAX_VALUE ? "-1" : String.valueOf(res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}