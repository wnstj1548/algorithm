import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int s = 0, e = 0;
    static long ret = 0;
    static long[] cnt;
    static int[] a;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        cnt = new long[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        while(e < n) {
            if (cnt[a[e]] == 0) {
                cnt[a[e]]++;
                e++;
            } else {
                ret += (e-s);
                cnt[a[s]]--;
                s++;
            }
        }

        long len = e - s;
        ret += len * (len + 1) / 2;

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}