import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, h;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static boolean check() {

        for(int i = 1; i <= n; i++) {
            int start = i;
            for(int j = 1; j <= h; j++) {
                if(visited[j][start]) {
                    start++;
                } else if (visited[j][start-1]) {
                    start--;
                }
            }
            if(start != i) return false;
        }

        return true;
    }

    public static void go(int here, int cnt) {
        if (cnt > 3 || cnt >= min) return;
        if (check()) {
            min = Math.min(min, cnt);
            return;
        }

        for(int i = here; i <= h; i++) {
            for(int j = 1; j < n; j++) {
                if (visited[i][j] || visited[i][j-1] || visited[i][j+1]) continue;
                visited[i][j] = true;
                go(i, cnt + 1);
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        visited = new boolean[h+1][n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            visited[y][x] = true;
        }

        go(1,0);

        bw.write(min == Integer.MAX_VALUE ? String.valueOf(-1) : String.valueOf(min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}