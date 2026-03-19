import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, c, m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static Shark[] sharks;
    static boolean[] isDelete;
    static int king;

    static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static void moveAll() {

        int[][] temp = new int[r][c];
        for(int i = 0; i < r; i++) {
            Arrays.fill(temp[i], -1);
        }

        for(int i = 0; i < m; i++) {
            if(isDelete[i]) continue;

            Shark shark = sharks[i];

            int move = shark.s;

            if(shark.d == 0 || shark.d == 1) {
                if (r > 1) move = move % (2 * (r - 1));
                else move = 0;
            } else {
                if (c > 1) move = move % (2 * (c - 1));
                else move = 0;
            }

            for(int j = 0; j < move; j++) {
                int ny = shark.r + dy[shark.d];
                int nx = shark.c + dx[shark.d];

                if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    if(shark.d == 0) shark.d = 1;
                    else if (shark.d == 1) shark.d = 0;
                    else if (shark.d == 2) shark.d = 3;
                    else if (shark.d == 3) shark.d = 2;

                    ny = shark.r + dy[shark.d];
                    nx = shark.c + dx[shark.d];
                }

                shark.r = ny;
                shark.c = nx;
            }

            if(temp[shark.r][shark.c] == -1) {
                temp[shark.r][shark.c] = i;
            } else {
                int other = temp[shark.r][shark.c];
                if (sharks[other].z > shark.z) {
                    isDelete[i] = true;
                } else {
                    isDelete[other] = true;
                    temp[shark.r][shark.c] = i;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ret = 0;

        sharks = new Shark[m];
        isDelete = new boolean[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int tempR = Integer.parseInt(st.nextToken()) -1;
            int tempC = Integer.parseInt(st.nextToken()) -1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) -1;
            int z = Integer.parseInt(st.nextToken());

            sharks[i] = new Shark(tempR, tempC, s, d, z);
        }

        for(king = 0; king < c; king++) {

            int min = Integer.MAX_VALUE;
            int idx = -1;

            for(int i = 0; i < sharks.length; i++) {
                if(isDelete[i]) continue;
                if(sharks[i].c == king) {
                    if(min > sharks[i].r) {
                        min = sharks[i].r;
                        idx = i;
                    }
                }
            }

            if(idx != -1) {
                isDelete[idx] = true;
                ret += sharks[idx].z;
            }

            moveAll();
        }

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}