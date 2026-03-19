import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] a = new boolean[101][101];

    static void drawDragonCurve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for(int gen = 1; gen <= g; gen++) {
            for(int i = directions.size() -1; i >= 0; i--) {
                directions.add((directions.get(i) + 1) % 4);
            }
        }

        a[y][x] = true;

        for(int dir : directions) {
            x = x + dx[dir];
            y = y + dy[dir];
            a[y][x] = true;
        }
    }

    static int countSquares() {
        int count = 0;

        for (int y = 0; y < 100; y++) {
            for(int x = 0; x < 100; x++) {
                if (a[y][x] && a[y+1][x] && a[y+1][x+1] && a[y][x+1]) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragonCurve(x, y, d, g);
        }

        bw.write(String.valueOf(countSquares()));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}