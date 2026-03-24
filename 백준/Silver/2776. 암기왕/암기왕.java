import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int t, n, m;
    static Set<Integer> aSet = new HashSet<>();
    static int[] b;

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

        t = nextInt();

        for(int j = 0; j < t; j++) {
            n = nextInt();

            for(int i = 0; i < n; i++) {
                aSet.add(nextInt());
            }

            m = nextInt();

            for(int i = 0; i < m; i++) {
                if(aSet.contains(nextInt())) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
            
            aSet.clear();
        }

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}