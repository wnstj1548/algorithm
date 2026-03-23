import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static int[] a;
    static long res = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long left = 0;
        long right = 0;

        st = new StringTokenizer(br.readLine());
        a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            right += a[i];
            left = Math.max(left, a[i]);
        }

        while(left <= right) {

            long mid = (left + right) / 2;

            long sum = 0;
            int count = 1;

            for(int i = 0; i < n; i++) {
                sum += a[i];

                if(sum > mid) {
                    count++;
                    sum = a[i];
                }
            }

            if(count <= m) {
                right = mid -1;
                res = Math.min(mid, res);
            } else {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}