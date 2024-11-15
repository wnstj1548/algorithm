import java.io.*;
import java.util.*;

public class Main {

    static int[][][] graph;
    static boolean[][][] visited;
    static int z, y, x, endZ, endY, endX;
    static int pos[][] = {{1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1}};

    public static int bfs(int c, int b, int a) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{c,b,a});
        visited[c][b][a] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int nowZ = cur[0];
            int nowY = cur[1];
            int nowX = cur[2];

            for(int i = 0; i < 6; i++) {
                int nz = nowZ + pos[i][0];
                int ny = nowY + pos[i][1];
                int nx = nowX + pos[i][2];

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < x && ny < y && nz < z && !visited[nz][ny][nx] && nz == endZ && ny == endY && nx == endX) {
                    return graph[nowZ][nowY][nowX];
                }

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < x && ny < y && nz < z && !visited[nz][ny][nx] && graph[nz][ny][nx] != 0) {
                    visited[nz][ny][nx] = true;
                    graph[nz][ny][nx] = graph[nowZ][nowY][nowX] + 1;
                    queue.add(new int[]{nz,ny,nx});
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> intList = new ArrayList<>();
        StringTokenizer st;

        while(true) {

            st = new StringTokenizer(br.readLine());

            z = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            if(x== 0 && y == 0 && z == 0) break;

            graph = new int[z][y][x];
            visited = new boolean[z][y][x];

            int startX = 0;
            int startY = 0;
            int startZ = 0;

            for(int i = 0; i<z; i++) {
                for(int j = 0; j<y; j++) {
                    String s = br.readLine();
                    for(int k = 0; k<x; k++) {

                        if(s.charAt(k) == 'E') {
                            graph[i][j][k] = 1;
                            endZ = i;
                            endY = j;
                            endX = k;
                        } else if(s.charAt(k) == 'S') {
                            graph[i][j][k] = 1;
                            startZ = i;
                            startY = j;
                            startX = k;
                        } else if(s.charAt(k) == '.') {
                            graph[i][j][k] = 1;
                        } else if(s.charAt(k) == '#') {
                            graph[i][j][k] = 0;
                        }
                    }
                }
                br.readLine();
            }

            intList.add(bfs(startZ, startY, startX));
        }

        for(int i : intList) {
            bw.write( i == -1 ? "Trapped!\n" : "Escaped in " + i + " minute(s).\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}