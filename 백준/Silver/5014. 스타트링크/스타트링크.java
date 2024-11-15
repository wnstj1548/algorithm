import java.io.*;
import java.util.*;

public class Main {

    static int f, s, g, u, d;
    static int[] graph;
    static int[] pos;
    static boolean[] visited;

    public static int bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {

            int x = queue.poll();

            if(x == g) {
                return graph[x];
            }

            for(int i = 0; i < 2; i++) {
                int nx = x + pos[i];
                if(nx > 0 && nx <= f && !visited[nx]) {
                    visited[nx] = true;
                    graph[nx] = graph[x] + 1;
                    queue.add(nx);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        graph = new int[f+1];
        pos = new int[] {u, -d};
        visited = new boolean[f+1];

        int result = bfs();

        bw.write(result == -1 ? "use the stairs\n" : result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}