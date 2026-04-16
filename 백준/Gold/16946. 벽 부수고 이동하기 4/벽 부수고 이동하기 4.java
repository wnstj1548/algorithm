import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[][] a;
    static int[][] group;
    static boolean[][] visited;
    static int[][] ret;

    static Map<Integer, Integer> groupSize = new HashMap<>();

    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, 1, -1, 0};

    static int dfs(int x, int y, int groupId) {

        visited[y][x] = true;
        group[y][x] = groupId;
        int size = 1;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx] || a[ny][nx] == 1) continue;
            size += dfs(nx, ny, groupId);
        }

        return size;
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        m = nextInt();

        a = new int[n][m];
        group = new int[n][m];
        ret = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int groupId = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 0) {
                    if(visited[i][j]) continue;
                    groupId++;
                    int size = dfs(j, i, groupId);
                    groupSize.put(groupId, size);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1) {
                    Set<Integer> groupSet = new HashSet<>();
                    int size = 0;
                    for(int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                        if(a[ny][nx] == 1) continue;

                        int tempGroupId = group[ny][nx];
                        if(groupSet.contains(tempGroupId)) continue;
                        groupSet.add(tempGroupId);
                        size += groupSize.get(tempGroupId);
                    }
                    ret[i][j] = (size+1) % 10;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(ret[i][j] + "");
            }
            bw.newLine();
        }

        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}