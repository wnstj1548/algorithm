import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static int[][] a;
    static int[][] rot;
    static boolean[] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;

    public static int[][] copyArr() {

        int[][] ret = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ret[i][j] = a[i][j];
            }
        }

        return ret;
    }

    public static void perm(int depth, List<Integer> temp) {
        if(depth == k) {
            go(temp, copyArr());
            return;
        }

        for(int i = 0 ; i < k; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(i);
            perm(depth + 1, temp);
            visited[i] = false;
            temp.remove(temp.size() -1);
        }
    }

    public static void go(List<Integer> temp, int[][] arr) {

        for(int i : temp) {
            int r = rot[i][0];
            int c = rot[i][1];
            int s = rot[i][2];
            rotate(r, c, s, arr);
        }

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < m; j++) {
                sum += arr[i][j];
            }
            min = Math.min(sum, min);
        }
    }

    public static void rotate(int r, int c, int s, int[][] arr) {

        if(s == 0) return;

        int minY = r-s;
        int maxY = r+s;
        int minX = c-s;
        int maxX = c+s;
        int pos = 0;

        int prev = arr[minY][minX];
        int nowY = minY;
        int nowX = minX;

        while(true) {
            int nx = nowX + dx[pos];
            int ny = nowY + dy[pos];
            if(maxX < nx || maxY < ny || minX > nx || minY > ny) {
                pos++;
                nx = nowX + dx[pos];
                ny = nowY + dy[pos];
            }

            int temp = arr[ny][nx];
            arr[ny][nx] = prev;
            prev = temp;

            nowY = ny;
            nowX = nx;

            if(ny == minY && nx == minX) break;
        }

        rotate(r,c,s-1, arr);
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        rot = new int[k][3];
        visited = new boolean[k];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            int s = Integer.parseInt(st.nextToken());
            rot[i] = new int[]{r, c, s};
        }

        perm(0,  new ArrayList<>());

        bw.write(String.valueOf(min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}