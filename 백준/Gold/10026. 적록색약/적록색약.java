import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[][] visited;
    static boolean[][] greenVisited;
    static char[][] graph;
    static char[][] greenGraph;
    static int count1;
    static int count2;
    static int[][] pos = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void bfs(int x, int y) {
        count1++;
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for(int i = 0; i<4; i++){
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && graph[nx][ny] == graph[nowX][nowY]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void greenBfs(int x, int y) {
        count2++;
        greenVisited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for(int i = 0; i<4; i++){
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !greenVisited[nx][ny] && greenGraph[nx][ny] == greenGraph[nowX][nowY]){
                    greenVisited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        greenGraph = new char[n][n];
        visited = new boolean[n][n];
        greenVisited = new boolean[n][n];

        for(int i = 0; i<n; i++) {
            String s = br.readLine();

            for(int j = 0; j<n; j++) {
                graph[i][j] = s.charAt(j);
                if(s.charAt(j) == 'R') {
                    greenGraph[i][j] = 'G';
                } else {
                    greenGraph[i][j] = s.charAt(j);
                }
            }
        }

        count1 = 0;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                }
                if(!greenVisited[i][j]) {
                    greenBfs(i, j);
                }
            }
        }

        bw.write(count1 + "\n");
        bw.write(count2 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}