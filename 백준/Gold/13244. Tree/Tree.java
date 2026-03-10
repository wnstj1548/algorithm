import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, t;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static boolean dfs(int now, int parent) {
        visited[now] = true;

        for(int next : graph[now]) {
            if(next == parent) continue;
            if(visited[next]) return false;
            if(!dfs(next, now)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            visited = new boolean[n+1];
            graph = new List[n+1];

            for(int j = 0; j < n+1; j++) {
                graph[j] = new ArrayList<>();
            }

            for(int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                graph[first].add(second);
                graph[second].add(first);
            }

            boolean isTree = dfs(1, 0);

            for(int j = 1; j <= n; j++) {
                if(!visited[j]) {
                    isTree = false;
                    break;
                }
            }

            bw.write(isTree ? "tree\n" : "graph\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}