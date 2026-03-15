import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, c, t, ret;
    static List<int[]> v1 = new ArrayList<>();
    static List<int[]> v2 = new ArrayList<>();

    static int[][] a = new int[50][50];
    static int[][] temp = new int[50][50];

    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};

    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};

    static void miseGo() {
        for(int i = 0; i < 50; i++) {
            Arrays.fill(temp[i], 0);
        }

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (a[i][j] != -1 && a[i][j] > 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            int spread = a[y][x] / 5;
            int count = 0;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy1[i];
                int nx = x + dx1[i];

                if(ny < 0 || nx < 0 || ny >= r || nx >= c || a[ny][nx] == -1) continue;

                temp[ny][nx] += spread;
                count++;
            }

            a[y][x] -= spread * count;
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                a[i][j] += temp[i][j];
            }
        }
    }

    static List<int[]> chung(int sy, int sx, int[] dy, int[] dx) {
        List<int[]> v = new ArrayList<>();
        int dir = 0;
        int y = sy;
        int x = sx;

        while(true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny == sy && nx == sx) break;

            if(ny < 0 || ny >= r || nx < 0 || nx >= c) {
                dir++;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }

            if(ny == sy && nx == sx) break;

            y = ny;
            x = nx;
            v.add(new int[]{ny, nx});
        }

        return v;
    }

    static void go(List<int[]> v) {
        for(int i = v.size()-1; i > 0; i--) {
            int[] cur = v.get(i);
            int[] prev = v.get(i-1);
            a[cur[0]][cur[1]] = a[prev[0]][prev[1]];
        }
        int[] first = v.get(0);
        a[first[0]][first[1]] = 0;
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        boolean flag = true;

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());

                if(a[i][j] == -1) {
                    if(flag) {
                        v1 = chung(i, j, dy1, dx1);
                        flag = false;
                    } else {
                        v2 = chung(i, j, dy2, dx2);
                    }
                }
            }
        }

        while(t-- > 0) {
            miseGo();
            go(v1);
            go(v2);
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (a[i][j] != -1) ret += a[i][j];
            }
        }

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}