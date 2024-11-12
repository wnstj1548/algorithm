import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] visited;
    static int[][] graph;
    static int count;
    static int[][] pos = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for(int i = 0; i<4; i++){
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        for(int i = 0; i<a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph = new int[n][m];
            visited = new boolean[n][m];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            count = 0;

            for(int j = 0; j < m; j++) {
                for(int b = 0; b<n; b++) {
                    if(graph[b][j] == 1 && !visited[b][j]) {
                        count++;
                        bfs(b,j);
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}