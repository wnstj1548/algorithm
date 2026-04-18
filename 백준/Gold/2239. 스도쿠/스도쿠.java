import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] a = new int[9][9];
    static List<int[]> empty = new ArrayList<>();
    static boolean finished = false;

    static boolean canPut(int y, int x, int num) {
        for(int i = 0; i < 9; i++) {
            if(a[y][i] == num) return false;
            if(a[i][x] == num) return false;
        }

        int sy = (y / 3) * 3;
        int sx = (x / 3) * 3;

        for(int i = sy; i < sy + 3; i++) {
            for(int j = sx; j < sx + 3; j++) {
                if(a[i][j] == num) return false;
            }
        }

        return true;
    }

    static void go(int idx) throws IOException {
        if(idx == empty.size()) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    bw.write(String.valueOf(a[i][j]));
                }
                bw.newLine();
            }
            finished = true;
            return;
        }

        int y = empty.get(idx)[0];
        int x = empty.get(idx)[1];

        for(int num = 1; num <= 9; num++) {
            if(canPut(y, x, num)) {
                a[y][x] = num;
                go(idx + 1);
                if (finished) return;
                a[y][x] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        for(int i = 0; i < 9; i++) {
            String s = br.readLine();
            for(int j = 0; j < 9; j++) {
                a[i][j] = s.charAt(j) - '0';
                if(a[i][j] == 0) empty.add(new int[]{i, j});
            }
        }

        go(0);

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
}