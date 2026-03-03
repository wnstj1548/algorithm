import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] arr;
    static boolean[][] zvisited;
    static boolean[][] visited;
    static int[] dy = {0, 1, -1, 0};
    static int[] dx = {1, 0, 0, -1};
    static int time = 0;
    static boolean ok = false;
    static Queue<int[]> zq = new ArrayDeque<>();
    static Queue<int[]> q = new ArrayDeque<>();

    public static void bfs() {

        while(!ok) {

            time++;

            while(!zq.isEmpty()) {
                int[] now = zq.poll();
                int nowY = now[0];
                int nowX = now[1];
                zvisited[nowY][nowX] = true;
                q.add(new int[]{nowY, nowX});

                for(int i = 0; i < 4; i++) {
                    int ny = nowY + dy[i];
                    int nx = nowX + dx[i];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if(zvisited[ny][nx] || arr[ny][nx] == 1) continue;
                    if(arr[ny][nx] == 0) {
                        zq.add(new int[]{ny, nx});
                        zvisited[ny][nx] = true;
                    }
                }
            }

            while(!q.isEmpty()) {
                int[] now = q.poll();
                int nowY = now[0];
                int nowX = now[1];
                visited[nowY][nowX] = true;

                for(int i = 0; i < 4; i++) {
                    int ny = nowY + dy[i];
                    int nx = nowX + dx[i];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if(arr[ny][nx] == 1) {
                        arr[ny][nx] = 0;
                        zq.add(new int[]{ny, nx});
                    }
                    if(arr[ny][nx] == -1) {
                        ok = true;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        zvisited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == '#') {
                    arr[i][j] = -1;
                } else if(s.charAt(j) == '*') {
                    arr[i][j] = 2;
                } else {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
        }

        zq.add(new int[]{startY -1, startX -1});

        bfs();

        bw.write(time + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}