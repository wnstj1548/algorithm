import java.io.*;
import java.util.*;

class Main {
    static int x,y;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] pos = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    static void bfs(int a, int b) {

        Queue<int[]> queue = new LinkedList<>();
        visited[a][b] = true;
        queue.add(new int[]{a, b});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >=0 && ny >=0 && nx < x && ny < y) {
                    if(!visited[nx][ny] && arr[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void reduce() {

        int[][] newArr = new int[x][y];

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(arr[i][j] != 0) {
                    int seaCount = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + pos[k][0];
                        int ny = j + pos[k][1];
                        if(nx >=0 && ny >=0 && nx < x && ny < y && arr[nx][ny] == 0) {
                            seaCount++;
                        }
                    }
                    newArr[i][j] = Math.max(0, arr[i][j] - seaCount);
                }
            }
        }
        arr = newArr;
    }

    static boolean isAllMelted() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] > 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[x][y];
        visited = new boolean[x][y];

        for(int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visited = new boolean[x][y];
            int count = 0;

            for(int i = 0; i < x; i++) {
                for(int j = 0; j < y; j++) {
                    if(!visited[i][j] && arr[i][j] != 0) {
                        bfs(i,j);
                        count++;
                    }
                }
            }

            if(count >= 2) {
                bw.write(result + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            if(isAllMelted()) {
                bw.write(0 + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            reduce();
            result++;
        }
    }
}