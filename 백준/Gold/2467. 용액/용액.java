import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static long[] a;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        n = nextInt();
        a = new long[n];

        for(int i = 0; i < n; i++) {
            a[i] = nextLong();
        }

        Arrays.sort(a);

        int left = 0;
        int right = n-1;

        min = a[left] + a[right];
        long retL = a[left];
        long retR = a[right];

        while(left < right) {

            long now = a[left] + a[right];

            if(Math.abs(min) > Math.abs(now)) {
                retL = a[left];
                retR = a[right];
                min = now;
            }

            if(now == 0) break;
            else if(now > 0) right--;
            else left++;
        }

        bw.write(retL + " " + retR);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }

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
}