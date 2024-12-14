import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static int n, m;
    static List<List<Integer>> graph;

    public static void dfs(int v, List<Integer> result, boolean[] visited) {

        visited[v] = true;
        result.add(v+1);

        for (int i : graph.get(v)) {
            if (!visited[i]) {
                dfs(i, result, visited);
            }
        }
    }

    public static void bfs(int v, List<Integer> result, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {

            int now = queue.poll();
            result.add(now+1);

            for(int i : graph.get(now)) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()) -1;

        graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i));
        }

        List<Integer> dfsResult = new ArrayList<>();
        dfs(v, dfsResult, new boolean[n]);

        for (int i : dfsResult) {
            bw.write(i + " ");
        }
        bw.newLine();

        List<Integer> bfsResult = new ArrayList<>();
        bfs(v, bfsResult, new boolean[n]);

        for (int i : bfsResult) {
            bw.write(i + " ");
        }
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}