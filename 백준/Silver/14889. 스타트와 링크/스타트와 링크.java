import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] a;
    static List<Integer> temp = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void combi(int start, int depth) {

        if(depth == (n / 2)) {
            go();
            return;
        }

        for(int i = start; i < n; i++) {
            temp.add(i);
            visited[i] = true;
            combi(i + 1, depth + 1);
            temp.remove(temp.size() -1);
            visited[i] = false;
        }
    }

    public static void go() {

        int select = 0;
        int unselect = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i] && visited[j]) select += a[i][j];
                else if (!visited[i] && !visited[j]) unselect += a[i][j];
            }
        }

        int diff = Math.abs(select - unselect);

        min = Math.min(min, diff);
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        a = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);

        bw.write(String.valueOf(min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}