import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] a;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[m];
        int left = 1;
        int right = 1;

        for(int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, a[i]);
        }

        while(left <= right) {
            int mid = (left + right) / 2;

            int temp = 0;

            for(int i = 0; i < m; i++) {
                temp += a[i] / mid;
                if(a[i] % mid != 0) temp++;
            }

            if(temp <= n) {
                ret = Math.min(ret, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}