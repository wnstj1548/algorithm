import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static int time = 1;
    static int[][] visited = new int[2][500001];
    static boolean ok = false;

    public static void bfs() {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        while(!queue.isEmpty()) {

            k += time;

            if(k > 500000) break;

            if (visited[time % 2][k] != 0) {
                ok = true;
                break;
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int here = queue.poll();

                for(int nx : new int[]{here + 1, here - 1, here * 2}) {
                    if(nx < 0 || nx > 500000 || visited[time % 2][nx] != 0) continue;
                    visited[time % 2][nx] = visited[(time - 1) % 2][here] + 1;

                    if(nx == k) {
                        ok = true;
                        break;
                    }

                    queue.add(nx);
                }
                if(ok) break;
            }
            if(ok) break;
            time++;
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            bw.write("0\n");
            bw.flush();
            br.close();
            bw.close();
            return;
        }

        bfs();

        bw.write(ok ? (time + "") : "-1");
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}