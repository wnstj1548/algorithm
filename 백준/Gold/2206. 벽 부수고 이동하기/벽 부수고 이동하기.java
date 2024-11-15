import java.io.*;
import java.util.*;

public class Main {

    static int[][][] graph;
    static boolean[][][] visited;
    static int n,m;
    static int pos[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];

            if (x == n - 1 && y == m - 1) {
                return graph[x][y][broken];
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {

                    if(broken == 1 && graph[nx][ny][1] == 1 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        graph[nx][ny][1] = graph[x][y][1] + 1;
                        queue.add(new int[]{nx, ny, 1});
                    }

                    if(broken == 0 && graph[nx][ny][0] == 1 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        graph[nx][ny][0] = graph[x][y][0] + 1;
                        queue.add(new int[]{nx, ny, 0});
                    }

                    if(broken == 0 && graph[nx][ny][1] == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        graph[nx][ny][1] = graph[x][y][0] + 1;
                        queue.add(new int[]{nx, ny, 1});
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m][2];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == '1') {
                    graph[i][j][0] = 0;
                    graph[i][j][1] = 0;
                } else {
                    graph[i][j][0] = 1;
                    graph[i][j][1] = 1;
                }
            }
        }

        int result = bfs();
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}