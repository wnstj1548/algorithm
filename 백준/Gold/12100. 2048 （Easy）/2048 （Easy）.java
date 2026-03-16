import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, ret;

    static class Board {
        int[][] a = new int[n][n];

        void rotate90() {
            int[][] temp = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    temp[i][j] = a[n - j - 1][i];
                }
            }

            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = temp[i][j];
                }
            }
        }

        void move() {
            int[][] temp = new int[n][n];

            for(int i = 0; i < n; i++) {
                int c = -1;
                int d = 0;

                for(int j = 0; j < n; j++) {
                    if (a[i][j] == 0) continue;

                    if (d == 1 && a[i][j] == temp[i][c]) {
                        temp[i][c] *= 2;
                        d = 0;
                    } else {
                        temp[i][++c] = a[i][j];
                        d = 1;
                    }
                }

                for(c++; c < n; c++) {
                    temp[i][c] = 0;
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = temp[i][j];
                }
            }
        }

        void getMax() {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    ret = Math.max(ret, a[i][j]);
                }
            }
        }

        Board copy() {
            Board newBoard = new Board();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    newBoard.a[i][j] = this.a[i][j];
                }
            }

            return newBoard;
        }
    }

    public static void go(Board c, int here) {
        if (here == 5) {
            c.getMax();
            return;
        }

        for(int i = 0; i < 4; i++) {
            Board d = c.copy();
            d.move();
            go(d, here + 1);
            c.rotate90();
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        Board c = new Board();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                c.a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(c, 0);

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}