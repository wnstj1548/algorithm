import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] adj;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void quad(int y, int x, int size) {

        int start = adj[y][x];

        if(size == 1) {
            sb.append(start);
            return;
        }

        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(adj[i][j] != start) {
                    int half = size / 2;
                    sb.append("(");
                    quad(y, x, half);
                    quad(y, x + half, half);
                    quad(y + half, x, half);
                    quad(y + half, x + half, half);
                    sb.append(")");
                    return;
                }
            }
        }

        sb.append(start);
    }

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        adj = new int[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                adj[i][j] = s.charAt(j) - '0';
            }
        }

        quad(0,0, n);

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}