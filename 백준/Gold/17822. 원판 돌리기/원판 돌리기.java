import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, t;
    static int[][] a;
    static int[] pointer;

    public static void rotate(int n, int dir, int count) {

        count %= m;

        if(dir == 0) {
            pointer[n] = (pointer[n] + ((m-1) * count)) % m;
        }

        if(dir == 1) {
            pointer[n] = (pointer[n] + (count)) % m;
        }
    }

    public static int getNum(int y, int x) {
        return a[y][(pointer[y] + x) % m];
    }

    public static void setNum(int y, int x, int num) {
        a[y][(pointer[y] + x) % m] = num;
    }

    public static boolean erase() {

        boolean[][] remove = new boolean[n][m];
        boolean isErase = false;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = getNum(i, j);

                if(num == 0) continue;

                if(i > 0) {
                    int left = getNum(i-1, j);
                    if(left == num) {
                        remove[i][j] = true;
                        remove[i-1][j] = true;
                        isErase = true;
                    }

                }

                if(i < n-1) {
                    int right = getNum(i+1, j);
                    if(right == num) {
                        remove[i][j] = true;
                        remove[i+1][j] = true;
                        isErase = true;
                    }
                }

                int down = getNum(i, j+1);
                int up = getNum(i, j+m-1);

                if(down == num) {
                    remove[i][j] = true;
                    remove[i][(j+1) % m] = true;
                    isErase = true;
                }

                if(up == num) {
                    remove[i][j] = true;
                    remove[i][(j+m-1) % m] = true;
                    isErase = true;
                }
            }
        }

        if(isErase) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(remove[i][j]) {
                        setNum(i, j, 0);
                    }
                }
            }
        }

        return isErase;
    }

    public static void adjust() {
        int sum = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int temp = getNum(i, j);
                if(temp == 0) continue;
                sum += temp;
                count++;
            }
        }

        if(count == 0) return;

        double avg = (double)sum / count;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int temp = getNum(i, j);
                if(temp == 0) continue;
                if(temp > avg) setNum(i, j, getNum(i, j) - 1);
                if(temp < avg) setNum(i, j, getNum(i, j) + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        pointer = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int j = x-1; j < n; j += x) {
                rotate(j, d, k);
            }

            boolean isErase = erase();

            if(!isErase) {
                adjust();
            }
        }

        int sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum += getNum(i,j);
            }
        }

        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}