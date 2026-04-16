import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static List<Point> pointList = new ArrayList<>();

    static class Point {
        long y;
        long x;

        public Point(long x, long y) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();

        for(int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();

            Point p = new Point(x, y);
            pointList.add(p);
        }

        long size = 0;

        for(int i = 0; i < pointList.size(); i++) {
            Point p = pointList.get(i);
            Point next = pointList.get((i+1) % n);

            size += p.x * next.y;
            size -= p.y * next.x;
        }

        bw.write(String.format("%.1f", Math.abs(size) / 2.0));
        bw.newLine();
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