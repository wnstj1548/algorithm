import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int t;
    static StringTokenizer st = null;

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {

        t = nextInt();

        for(int i = 0; i < t; i++) {
            int n = nextInt();
            int m = nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for(int j = 0; j < n; j++) {
                a[j] = nextInt();
            }

            for(int j = 0; j < m; j++) {
                b[j] = nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int aStart = 0;
            int bStart = 0;
            int res = 0;

            while(aStart < n && bStart < m) {
                if(a[aStart] > b[bStart]) {
                    bStart++;
                } else {
                    res += bStart;
                    aStart++;
                }
            }

            while(aStart < n) {
                res += bStart;
                aStart++;
            }

            bw.write(String.valueOf(res));
            bw.newLine();
        }

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}