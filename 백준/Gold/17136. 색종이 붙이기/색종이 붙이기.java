import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;

    static final int INF = 987654321;
    static int[][] a = new int[10][10];
    static int[] paper = new int[6];
    static int ret = INF;
    static int n = 10;

    static boolean check(int y, int x, int size) {

        if(y + size > n || x + size > n) return false;

        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(a[i][j] == 0) return false;
            }
        }

        return true;
    }

    static void draw(int y, int x, int size, int value) {
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                a[i][j] = value;
            }
        }
    }

    static void dfs(int y, int x, int cnt) {
        if(cnt >= ret) return;

        if(x == n) {
            dfs(y+1, 0, cnt);
            return;
        }

        if(y == n) {
            ret = Math.min(ret, cnt);
            return;
        }

        if(a[y][x] == 0) {
            dfs(y, x+1, cnt);
            return;
        }

        for(int size = 5; size >= 1; size--) {
            if(paper[size] == 5) continue;

            if(check(y, x, size)) {
                paper[size]++;
                draw(y, x, size, 0);
                dfs(y, x+size, cnt+1);
                draw(y,x, size, 1);
                paper[size]--;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                a[i][j] = nextInt();
            }
        }

        dfs(0,0,0);

        bw.write(ret == INF ? "-1" : String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    private static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    private static long nextLong() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }
}