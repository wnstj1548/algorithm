import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int t, k;
    static int[][] a;
    static int[] pointer;
    static int ret = 0;

    public static int getValue(int num, int idx) {
        return a[num][(pointer[num] + idx) % 8];
    }

    public static void rotate(int num, int direct) {
        if(direct == 1) {
            pointer[num] = (pointer[num] + 7) % 8;
        } else if(direct == -1){
            pointer[num] = (pointer[num] + 1) % 8;
        }
    }

    public static void main(String[] args) throws Exception {

        t = Integer.parseInt(br.readLine());
        pointer = new int[t];
        a = new int[t][8];

        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            for(int j = 0; j < 8; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) -1;
            int direct = Integer.parseInt(st.nextToken());

            int[] dir = new int[t];
            dir[num] = direct;

            for(int j = num; j > 0; j--) {
                if (getValue(j - 1, 2) != getValue(j, 6)) {
                    dir[j-1] = -dir[j];
                } else {
                    break;
                }
            }

            for(int j = num; j < t-1; j++) {
                if (getValue(j, 2) != getValue(j+1, 6)) {
                    dir[j+1] = -dir[j];
                } else {
                    break;
                }
            }

            for(int j = 0; j < t; j++) {
                rotate(j, dir[j]);
            }
        }

        for(int i = 0; i < t; i++) {
            if(getValue(i, 0) == 1) ret++;
        }

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}