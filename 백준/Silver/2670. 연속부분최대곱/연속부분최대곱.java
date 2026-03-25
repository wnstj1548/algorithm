import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n;
    static double[] d;
    static double res;

    public static void main(String[] args) throws Exception {

        n = nextInt();
        d = new double[n];

        for(int i = 0; i < n; i++) {
            d[i] = nextDouble();
        }

        res = d[0];

        double prev = 1;
        for(int i = 0; i < n; i++) {
            prev = Math.max(prev * d[i], d[i]);
            res = Math.max(prev, res);
        }

        bw.write(String.format("%.3f", res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
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

    public static double nextDouble() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Double.parseDouble(st.nextToken());
    }
}