import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m = 0;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken().trim();

            if("all".equals(s)) {
                m = (1 << 21) -1;
                continue;
            } else if ("empty".equals(s)) {
                m = 0;
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if("add".equals(s)) m |= (1 << num);
            else if ("remove".equals(s)) m &= ~(1 << num);
            else if ("check".equals(s)) {
                if((m & (1 << num)) != 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if ("toggle".equals(s)) m ^= (1 << num);
        }

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}