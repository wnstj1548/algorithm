import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int r, c, k;
    static boolean[][] visited;
    static char[][] arr;
    static int count = 0;
    public static void dfs(int y, int x, int depth) {

        if(y == 0 && x == c-1) {
            if(depth == k) count++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if(visited[ny][nx] || arr[ny][nx] == 'T') continue;
            visited[ny][nx] = true;
            dfs(ny, nx, depth+1);
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited[r-1][0] = true;
        dfs(r-1, 0, 1);

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}