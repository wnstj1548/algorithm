import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, c;
    static char[][] arr;
    static int[] dy = {0, 1, -1, 0};
    static int[] dx = {1, 0, 0, -1};
    static int day = 0;
    static boolean[][] visited;
    static boolean[][] swanVisited;
    static Queue<int[]> q = new ArrayDeque<>();
    static Queue<int[]> temp = new ArrayDeque<>();
    static Queue<int[]> swanQ = new ArrayDeque<>();
    static Queue<int[]> swanTemp = new ArrayDeque<>();
    static int startY, startX;

    public static void water() {

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(visited[ny][nx]) continue;
                if(arr[ny][nx] == 'X') {
                    visited[ny][nx] = true;
                    arr[ny][nx] = '.';
                    temp.add(new int[]{ny, nx});
                }
            }
        }
    }

    public static boolean swan() {

        while(!swanQ.isEmpty()) {
            int[] now = swanQ.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(swanVisited[ny][nx]) continue;
                swanVisited[ny][nx] = true;
                if(arr[ny][nx] == '.') {
                    swanQ.add(new int[]{ny, nx});
                } else if (arr[ny][nx] == 'X') {
                    swanTemp.add(new int[]{ny, nx});
                } else if (arr[ny][nx] == 'L') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];
        swanVisited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
                if(s.charAt(j) == '.' || s.charAt(j) == 'L'){
                    q.add(new int[] {i,j});
                    visited[i][j] = true;
                }
                if(s.charAt(j) == 'L') {
                    startY = i;
                    startX = j;
                }
            }
        }

        swanQ.add(new int[]{startY, startX});
        swanVisited[startY][startX] = true;

        while(!swan()) {
            water();
            q = temp;
            swanQ = swanTemp;

            temp = new ArrayDeque<>();
            swanTemp = new ArrayDeque<>();

            day++;
        }

        bw.write(day + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}