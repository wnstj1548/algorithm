import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static boolean check(int y, int x) {

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) return false;
            if(visited[ny][nx]) return false;
        }

        return true;
    }

    public static void go(int now, int depth) {

        if(depth == 3) {
            min = Math.min(now, min);
            return;
        }

        for(int i = 1; i < n-1; i++) {
            for(int j = 1; j < n-1; j++) {
                if(check(i,j)) {

                    visited[i][j] = true;
                    now += arr[i][j];

                    for(int k = 0; k < 4; k++) {

                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        now += arr[ny][nx];
                        visited[ny][nx] = true;
                    }

                    go(now, depth+1);

                    visited[i][j] = false;
                    now -= arr[i][j];

                    for(int k = 0; k < 4; k++) {

                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        now -= arr[ny][nx];
                        visited[ny][nx] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0);

        bw.write(min + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}