import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] a;
    static List<Camera> cameraList = new ArrayList<>();
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    static class Camera {
        int y;
        int x;
        int num;

        public Camera(int y, int x, int num) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static void watch(int[][] arr, int y, int x, int dir) {
        int ny = y + dy[dir];
        int nx = x + dx[dir];

        while(ny >= 0 && nx >= 0 && ny < n && nx < m && arr[ny][nx] != 6) {
            if(arr[ny][nx] == 0) {
                arr[ny][nx] = -1;
            }
            ny += dy[dir];
            nx += dx[dir];
        }
    }

    public static void dfs(int depth, int[][] arr) {

        if(depth == cameraList.size()) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == 0) cnt++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }

        Camera camera = cameraList.get(depth);

        if(camera.num == 1) {
            for(int i = 0; i < 4; i++) {
                int[][] next = copyArr(arr);
                watch(next, camera.y, camera.x, i);
                dfs(depth + 1, next);
            }
        } else if (camera.num == 2) {
            for(int i = 0; i < 2; i++) {
                int[][] next = copyArr(arr);
                watch(next, camera.y, camera.x, i);
                watch(next, camera.y, camera.x, i+2);
                dfs(depth + 1, next);
            }
        } else if (camera.num == 3) {
            for (int d = 0; d < 4; d++) {
                int[][] next = copyArr(arr);
                watch(next, camera.y, camera.x, d);
                watch(next, camera.y, camera.x, (d + 1) % 4);
                dfs(depth + 1, next);
            }
        } else if (camera.num == 4) {
            for (int d = 0; d < 4; d++) {
                int[][] next = copyArr(arr);
                watch(next, camera.y, camera.x, d);
                watch(next, camera.y, camera.x, (d + 1) % 4);
                watch(next, camera.y, camera.x, (d + 2) % 4);
                dfs(depth + 1, next);
            }
        } else if (camera.num == 5) {
            int[][] next = copyArr(arr);
            for (int d = 0; d < 4; d++) {
                watch(next, camera.y, camera.x, d);
            }
            dfs(depth + 1, next);
        }
    }

    public static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());

                if(a[i][j] > 0 && a[i][j] < 6) {
                    cameraList.add(new Camera(i, j, a[i][j]));
                }
            }
        }

        dfs(0, a);

        bw.write(String.valueOf(min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}