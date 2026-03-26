import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n;
    static int[][] a;
    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 1, 0};
    static int[][][] dp;

    // 0 : 가로, 1: 대각선, 2 : 세로
    static int dfs(int nowY, int nowX, int state) {

        int res = 0;

        if(dp[nowY][nowX][state] != -1) {
            return dp[nowY][nowX][state];
        }

        if(nowY == n-1 && nowX == n-1) {
            return 1;
        }

        if(state == 0) {
            for(int i : new int[]{0, 1}) {
                int ny = dy[i] + nowY;
                int nx = dx[i] + nowX;
                if(ny >= n || nx >= n) continue;
                if(i == 1) {
                    if(a[nowY][nowX + 1] == 1 || a[nowY + 1][nowX] == 1 || a[nowY + 1][nowX + 1] == 1) continue;
                } else {
                    if (a[ny][nx] == 1) continue;
                }
                res += dfs(ny, nx, i);
            }
        } else if (state == 1) {
            for(int i : new int[]{0, 1, 2}) {
                int ny = dy[i] + nowY;
                int nx = dx[i] + nowX;
                if(ny >= n || nx >= n) continue;
                if(i == 1) {
                    if(a[nowY][nowX + 1] == 1 || a[nowY + 1][nowX] == 1 || a[nowY + 1][nowX + 1] == 1) continue;
                } else {
                    if (a[ny][nx] == 1) continue;
                }
                res += dfs(ny, nx, i);
            }
        } else if (state == 2) {
            for(int i : new int[]{1, 2}) {
                int ny = dy[i] + nowY;
                int nx = dx[i] + nowX;
                if(ny >= n || nx >= n) continue;
                if(i == 1) {
                    if(a[nowY][nowX + 1] == 1 || a[nowY + 1][nowX] == 1 || a[nowY + 1][nowX + 1] == 1) continue;
                } else {
                    if (a[ny][nx] == 1) continue;
                }
                res += dfs(ny, nx, i);
            }
        }

        dp[nowY][nowX][state] = res;

        return res;
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        a = new int[n][n];
        dp = new int[n][n][3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }

        int result = dfs(0, 1, 0);

        bw.write(String.valueOf(result));
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