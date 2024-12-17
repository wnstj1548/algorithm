import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int max;
    static int farIndex;

    public static void dfs(int now, int weight) {

        visited[now] = true;

        if(max < weight) {
            max = weight;
            farIndex = now;
        }

        for(Node n : graph[now]) {
            if(!visited[n.value]) {
                dfs(n.value, weight + n.weight);
            }
        }
    }

    static class Node {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int now = Integer.parseInt(st.nextToken());

            int a;

            while((a = Integer.parseInt(st.nextToken())) != -1) {
                graph[now].add(new Node(a, Integer.parseInt(st.nextToken())));
            }
        }

        max = Integer.MIN_VALUE;
        visited = new boolean[n + 1];

        Arrays.fill(visited, false);
        farIndex = 1;
        dfs(1, 0);

        max = Integer.MIN_VALUE;
        Arrays.fill(visited, false);
        dfs(farIndex, 0);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}