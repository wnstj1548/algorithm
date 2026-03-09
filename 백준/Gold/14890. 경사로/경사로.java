import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, l;
    static int[][] a, b;
    static int ret = 0;

    public static void solve(int[][] arr) {

        for(int i = 0; i < n; i++) {
            int cnt = 1;
            int j;
            for(j = 0; j < n -1; j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    cnt++;
                } else if (arr[i][j] + 1 == arr[i][j+1] && cnt >= l) {
                    cnt = 1;
                } else if (arr[i][j] - 1 == arr[i][j+1] && cnt >= 0) {
                    cnt = 1-l;
                } else {
                    break;
                }
            }

            if(j == n - 1 && cnt >= 0) {
                ret++;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        b = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                b[j][i] = a[i][j];
            }
        }

        solve(a);
        solve(b);

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}