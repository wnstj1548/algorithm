import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] a;
    static StringTokenizer st = null;
    static int res = Integer.MAX_VALUE;

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        m = nextInt();

        a = new int[n];

        int left = 0;
        int right = 0;

        for(int i = 0; i< n; i++) {
            a[i] = nextInt();
            right += a[i];
            left = Math.max(left, a[i]);
        }

        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int sum = 0;

            for(int i = 0; i < n; i++) {
                sum += a[i];

                if(mid < sum) {
                    count++;
                    sum = a[i];
                }
            }

            if(count <= m) {
                right = mid - 1;
                res = Math.min(res, mid);
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