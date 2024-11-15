import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int pos[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int n, count;

    public static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for(int i = 0; i<4; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    count++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j<s.length(); j++) {
                graph[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                count = 0;
                if(graph[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i,j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);

        bw.write(result.size() + "\n");

        for(int i : result) {
            bw.write(i + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}