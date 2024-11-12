import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] visited;

    public static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited = new int[100001];
        visited[x] = 1;

        while (!queue.isEmpty()) {


            int nowX = queue.poll();

            if(nowX == y) {
                return visited[nowX] -1;
            }

            if (2 * nowX >= 0 && 2 *nowX <= 100000 && visited[nowX * 2] == 0) {
                queue.add(nowX * 2);
                visited[nowX * 2] = visited[nowX] + 1;
            }

            if (nowX + 1 >= 0 && nowX + 1 <= 100000 && visited[nowX + 1] == 0) {
                queue.add(nowX + 1);
                visited[nowX + 1] = visited[nowX] + 1;
            }

            if (nowX - 1 >= 0 && nowX - 1 <= 100000 && visited[nowX - 1] == 0) {
                queue.add(nowX - 1);
                visited[nowX - 1] = visited[nowX] + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = bfs(n, m);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}