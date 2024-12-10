import java.io.*;
import java.util.*;

public class Main {

    static int n, m, count;
    static List<List<Integer>> graph;
    static int[] result;


    public static void dfs(int start, List<Integer> reachedNodes, boolean[] visited) {

        if(!visited[start]) {
            visited[start] = true;

            for(int next : graph.get(start)) {
                if(!visited[next]) {
                    reachedNodes.add(next);
                    dfs(next, reachedNodes, visited);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        result = new int[n];
        count = 0;

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;

            graph.get(a).add(b);
        }

        for(int i = 0; i < n; i++) {

            List<Integer> reachedNodes = new ArrayList<>();
            dfs(i, reachedNodes, new boolean[n]);

            for(int j : reachedNodes) {
                result[j]++;
                result[i]++;
            }
        }

        for(int i : result) {
            if(i == n-1) {
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}