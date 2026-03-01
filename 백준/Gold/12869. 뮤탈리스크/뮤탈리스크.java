import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] scv = new int[3];
    static int[][] damage = new int[][] {
            {9,3,1},
            {9,1,3},
            {3,1,9},
            {3,9,1},
            {1,9,3},
            {1,3,9}
    };
    static int[][][] visited = new int[64][64][64];
    static int n;

    public static int solve(int a, int b, int c) {
        Queue<int[]> queue = new ArrayDeque<>();

        visited[a][b][c] = 1;
        queue.add(new int[] {a,b,c});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int ca = now[0];
            int cb = now[1];
            int cc = now[2];

            if(visited[0][0][0] != 0) return visited[0][0][0] -1;

            for(int i = 0; i < 6; i++) {
                int na = Math.max(0, ca - damage[i][0]);
                int nb = Math.max(0, cb - damage[i][1]);
                int nc = Math.max(0, cc - damage[i][2]);

                if(visited[na][nb][nc] != 0) continue;

                visited[na][nb][nc] = visited[ca][cb][cc] + 1;
                queue.add(new int[]{na, nb, nc});
            }
        }

        return visited[0][0][0] -1;
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        int result = solve(scv[0], scv[1], scv[2]);

        bw.write(result + "");
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}