import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] adj;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static int bfs(int y, int x) {

        int[][] temp = new int[n][m];
        int max = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(adj[ny][nx] == -1 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                temp[ny][nx] = temp[nowY][nowX] + 1;
                max = Math.max(temp[ny][nx], max);
                queue.add(new int[]{ny, nx});
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max = 0;
        adj = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m ; j++) {
                if(s.charAt(j) == 'W') {
                    adj[i][j] = -1;
                } else {
                    adj[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(adj[i][j] == 0) {
                    max = Math.max(max, bfs(i,j));
                }
            }
        }

        bw.write(max + "");
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}