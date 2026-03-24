import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static long n;
    static int m;
    static int[] a;
    static int res = 0;

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

        n = nextLong();
        m = nextInt();
        a = new int[m];
        long left = 0;
        long right = 0;

        if (n <= m) {
            bw.write(String.valueOf(n));
            bw.newLine();
            bw.flush();
            return;
        }

        for(int i = 0; i < m; i++) {
            int temp = nextInt();
            a[i] = temp;
            right = Math.max(temp, right);
        }

        right *= n;
        long time = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = m;

            for(int i = 0; i < m; i++) {
                cnt += (mid / a[i]);
            }

            if(cnt >= n) {
                right = mid -1;
                time = mid;
            } else {
                left = mid + 1;
            }
        }

        long before = m;
        for(int i = 0; i < m; i++) {
            before += ((time -1) / a[i]);
        }

        for(int i = 0; i < m; i++) {
            if(time % a[i] == 0) {
                before++;
                if(before == n) {
                    res = i + 1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}