import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, m;
    static Set<Integer> a = new HashSet<>();

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        m = nextInt();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            a.add(nextInt());
        }

        for(int i = 0; i < m; i++) {
            int temp = nextInt();
            if(a.contains(temp)) cnt++;
        }

        int res = (n - cnt) + (m - cnt);

        bw.write(String.valueOf(res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}