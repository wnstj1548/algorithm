import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, c;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};
    static Set<Character> set = new HashSet<>();
    static int max = Integer.MIN_VALUE;

    public static void dfs(int y, int x, int depth) {

        if(set.contains(arr[y][x])) return;

        visited[y][x] = true;
        set.add(arr[y][x]);
        max = Math.max(max, depth);

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if(visited[ny][nx]) continue;
            dfs(ny, nx, depth + 1);
        }

        set.remove(arr[y][x]);
        visited[y][x] = false;
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1);

        bw.write(max + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}