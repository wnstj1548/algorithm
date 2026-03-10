import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] arr;
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        // 0 : 가로, 1 : 세로
        for(int s = 0; s < 1 << (n * m); s++) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int cur = 0;
                for(int j = 0; j < m; j++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + arr[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for(int j = 0; j < m; j++) {
                int cur = 0;
                for(int i = 0; i < n; i++) {
                    int k = i * m + j;
                    if((s & ( 1 << k)) != 0) {
                        cur = cur * 10 + arr[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ret = Math.max(ret, sum);
        }

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}