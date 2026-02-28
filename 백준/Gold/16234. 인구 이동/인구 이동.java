import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, l, r;
    static int day = 0;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static boolean[][] visited;
    static int[][] adj;
    static boolean isChanged = true;
    static Map<int[], Integer> map = new HashMap<>();

    public static void bfs(int y, int x) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        List<int[]> tempList = new ArrayList<>();
        tempList.add(new int[]{y,x});
        visited[y][x] = true;
        int sum = adj[y][x];

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(visited[ny][nx]) continue;

                int nowPerson = adj[nowY][nowX];
                int nextPerson = adj[ny][nx];

                if(l > Math.abs(nowPerson - nextPerson) || r < Math.abs(nowPerson - nextPerson)) continue;

                sum += nextPerson;
                queue.add(new int[]{ny, nx});
                tempList.add(new int[]{ny, nx});
                isChanged = true;
                visited[ny][nx] = true;
            }
        }

        if(isChanged) {
            int div = sum / tempList.size();

            for(int[] temp: tempList) {
                map.put(temp, div);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        adj = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(isChanged) {

            isChanged = false;

            for(int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j]) continue;
                    bfs(i,j);
                }
            }

            if(isChanged) {
                day++;

                for(int[] key : map.keySet()) {
                    adj[key[0]][key[1]] = map.get(key);
                }

                map.clear();
            }
        }

        bw.write(day + "");
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}