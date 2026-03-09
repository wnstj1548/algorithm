import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[][] visited;
    static int[][] arr;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int roomCount = 0;
    static int max = Integer.MIN_VALUE;
    static int big = Integer.MIN_VALUE;
    static List<Integer> roomSize = new ArrayList<>();

    public static int dfs(int y, int x, int roomId) {

        visited[y][x] = roomId;
        int size = 1;

        for(int i = 0; i < 4; i++) {

            if((arr[y][x] & 1 << i) != 0) continue;

            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
            if(visited[ny][nx] != 0) continue;
            size += dfs(ny, nx, roomId);
        }

        return size;
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        roomSize.add(0);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] != 0) continue;
                roomCount++;
                int size = dfs(i,j, roomCount);
                roomSize.add(size);
                max = Math.max(max, size);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i + 1 < m) {
                    int a = visited[i+1][j];
                    int b = visited[i][j];
                    if(a != b) {
                        big = Math.max(big, roomSize.get(a) + roomSize.get(b));
                    }
                }
                
                if(j + 1 < n) {
                    int a = visited[i][j+1];
                    int b = visited[i][j];
                    if(a != b) {
                        big = Math.max(big, roomSize.get(a) + roomSize.get(b));
                    }
                }
            }
        }

        bw.write(roomCount + "\n");
        bw.write(max + "\n");
        bw.write(big + "\n");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}