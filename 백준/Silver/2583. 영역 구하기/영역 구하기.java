import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static int n,m;
    static boolean[][] visited;
    static int count;
    static int pos[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[1];
            int nowY = arr[0];

            for(int i = 0; i< 4; i++) {
                int nx = nowX + pos[i][1];
                int ny = nowY + pos[i][0];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[ny][nx] && graph[ny][nx] == 0) {
                    count++;
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];
        List<Integer> result = new LinkedList<>();

        for(int i = 0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            for(int j = startX; j< endX; j++) {
                for(int k = startY; k < endY; k++) {
                    graph[k][j] = 1;
                }
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                count = 0;
                if(!visited[j][i] && graph[j][i] == 0) {
                    count++;
                    bfs(j,i);
                    result.add(count);
                }
            }
        }

        bw.write(result.size() + "\n");

        Collections.sort(result);

        for(int i : result) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}