import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, l;
    static int[][][] graph;
    static int[][] pos = {{1,0,0}, {0,1,0}, {-1,0,0}, {0,-1,0}, {0,0,1}, {0,0,-1}};

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0; i< m; i++){
            for(int j = 0; j < l; j++) {
                for(int k = 0; k < n; k++) {
                    if(graph[k][i][j] == 1) {
                        queue.add(new int[]{k, i, j});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean change = false;

            for(int i = 0; i< size; i++) {
                int[] arr = queue.poll();
                int nowZ = arr[0];
                int nowX = arr[1];
                int nowY = arr[2];

                for(int j=0; j<6; j++) {
                    int nz = nowZ + pos[j][0];
                    int nx = nowX + pos[j][1];
                    int ny = nowY + pos[j][2];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < l && nz >= 0 && nz < n && graph[nz][nx][ny] == 0) {
                        graph[nz][nx][ny] = 1;
                        queue.add(new int[]{nz, nx, ny});
                        change = true;
                    }
                }
            }
            if(change) {
                count++;
            }
        }
        if (isZero(graph)) {
            return -1;
        }

        return count;
    }

    public static boolean isZero(int[][][] graph) {
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < l; k++) {
                    if(graph[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        graph = new int[n][m][l];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < l; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
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