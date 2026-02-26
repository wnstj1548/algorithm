import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] adj;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int n, m;
    static int max = Integer.MIN_VALUE;
    static List<int[]> virusList = new ArrayList<>();
    static List<int[]> wallList = new ArrayList<>();
    static boolean[][] visited;

    public static void combi(List<int[]> resultList, List<int[]> wallList, boolean[][] combiVisited) {

        if(resultList.size() == 3) {
            for(int[] addWall : resultList) {
                adj[addWall[0]][addWall[1]] = 1;
            }

            max = Math.max(max, solve());

            for(int[] addWall : resultList) {
                adj[addWall[0]][addWall[1]] = 0;
            }

            return;
        }

        for(int[] wallArr : wallList) {
            
            int y = wallArr[0];
            int x = wallArr[1];

            if(combiVisited[y][x]) continue;

            combiVisited[y][x] = true;
            resultList.add(new int[]{y, x});
            combi(resultList, wallList, combiVisited);
            resultList.remove(resultList.size() -1);
            combiVisited[y][x] = false;
        }
    }

    public static int solve() {

        for(boolean[] visit : visited) {
            Arrays.fill(visit, false);
        }

        for(int[] virus : virusList) {
            int y = virus[0];
            int x = virus[1];

            dfs(y, x);
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(adj[i][j] == 0 && !visited[i][j]) count++;
            }
        }
        return count;
    }

    public static void dfs(int y, int x) {

        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if(visited[ny][nx] || adj[ny][nx] == 1) continue;
            dfs(ny, nx);
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0) wallList.add(new int[]{i,j});
                if(temp == 2) virusList.add(new int[]{i,j});
                adj[i][j] = temp;
            }
        }

        combi(new ArrayList<>(), wallList, new boolean[n][m]);

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}