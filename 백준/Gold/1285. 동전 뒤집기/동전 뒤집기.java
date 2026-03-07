import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int min = Integer.MAX_VALUE;
    static char[][] arr;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                char c = s.charAt(j);
                arr[i][j] = c;
            }
        }

        for(int mask = 0; mask < (1 << n); mask++) {

            int sum = 0;

            for(int x = 0; x < n; x++) {
                int backCount = 0;

                for(int y = 0; y < n; y++) {
                    char now = arr[y][x];

                    if((mask & 1 << y) != 0) {
                        now = now == 'H' ? 'T' : 'H';
                    }

                    if(now == 'T') backCount++;
                }
                sum += Math.min(backCount, n - backCount);
            }
            min = Math.min(min, sum);
        }
        
        bw.write(String.valueOf(min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}