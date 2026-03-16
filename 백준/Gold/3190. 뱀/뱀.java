import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k, l;
    static int[][] a;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Map<Integer, Character> turn = new HashMap<>();

    public static int go() {
        int time = 0;
        int nowY = 0;
        int nowX = 0;
        int dir = 0;

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addLast(new int[]{0, 0});
        a[0][0] = 2;

        while(true) {
            time++;

            int ny = nowY + dy[dir];
            int nx = nowX + dx[dir];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) break;

            boolean apple = (a[ny][nx] == 1);
            if(a[ny][nx] == 2) break;

            a[ny][nx] = 2;
            snake.addLast(new int[]{ny, nx});

            if(!apple) {
                int[] tail = snake.pollFirst();
                a[tail[0]][tail[1]] = 0;
            }

            nowY = ny;
            nowX = nx;

            if(turn.containsKey(time)) {
                char c = turn.get(time);
                if (c == 'L') dir = (dir + 3) % 4;
                else dir = (dir + 1) % 4;
            }
        }

        return time;
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        a = new int[n][n];

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            a[b-1][c-1] = 1;
        }

        l = Integer.parseInt(br.readLine());

        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            char temp = st.nextToken().charAt(0);
            turn.put(b, temp);
        }

        int res = go();

        bw.write(String.valueOf(res));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}