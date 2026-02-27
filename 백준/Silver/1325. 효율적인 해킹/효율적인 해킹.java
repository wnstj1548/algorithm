import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer>[] edge;
    static boolean[] visited;
    static int count = 0;

    public static void dfs(int n) {

        visited[n] = true;
        count++;

        for(Integer i : edge[n]) {
            if(visited[i]) continue;
            dfs(i);
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edge = new List[n+1];

        for(int i = 1; i < n+1; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[b].add(a);
        }

        int max = 0;
        int[] counts = new int[n+1];

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            count = 0;
            dfs(i);
            if(max < count) max = count;
            counts[i] = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (counts[i] == max) sb.append(i).append(' ');
        }

        if (sb.length() > 0) sb.setLength(sb.length() - 1);

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}