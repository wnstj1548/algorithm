import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, k;
    static List<Integer>[][] board;
    static Horse[] horses;
    static int[][] a;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static class Horse {
        int y;
        int x;
        int pos;

        public Horse(int y, int x, int pos) {
            this.y = y;
            this.x = x;
            this.pos = pos;
        }
    }

    static int reverseDir(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }

    public static boolean isEnd() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j].size() >= 4) return true;
            }
        }

        return false;
    }

    static boolean isBlueOrOut(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= n || a[y][x] == 2;
    }

    static void move(int idx) {
        Horse horse = horses[idx];
        int y = horse.y;
        int x = horse.x;
        int pos = horse.pos;

        int ny = y + dy[pos];
        int nx = x + dx[pos];

        if(isBlueOrOut(ny, nx)) {
            horse.pos = reverseDir(horse.pos);

            ny = y + dy[horse.pos];
            nx = x + dx[horse.pos];

            if(isBlueOrOut(ny, nx)) return;
        }

        List<Integer> cur = board[y][x];
        int start = -1;

        for(int i = 0; i < cur.size(); i++) {
            if(cur.get(i) == idx) {
                start = i;
                break;
            }
        }

        List<Integer> moving = new ArrayList<>();

        for(int i = start; i < cur.size(); i++) {
            moving.add(cur.get(i));
        }

        for (int i = cur.size() - 1; i >= start; i--) {
            cur.remove(i);
        }

        if (a[ny][nx] == 1) {
            Collections.reverse(moving);
        }

        for (int num : moving) {
            board[ny][nx].add(num);
            horses[num].y = ny;
            horses[num].x = nx;
        }
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        k = nextInt();

        board = new ArrayList[n][n];
        horses = new Horse[k];
        a = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }

        for(int i = 0; i < k; i++) {

            int y = nextInt() -1;
            int x = nextInt() -1;
            int pos = nextInt() -1;

            horses[i] = new Horse(y, x, pos);
            board[y][x].add(i);
        }

        for(int i = 1; i <= 1000; i++) {
            for(int j = 0; j < k; j++) {
                move(j);
                if(isEnd()) {
                    bw.write(i + "\n");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write("-1\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}