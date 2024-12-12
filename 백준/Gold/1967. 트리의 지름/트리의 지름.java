import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farNode = 0;

    static class Node {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static void dfs(int start, int dist) {
        visited[start] = true;

        if(dist > maxDistance) {
            maxDistance = dist;
            farNode = start;
        }

        for(Node node : tree[start]) {
            if(!visited[node.value]) {
                dfs(node.value, dist + node.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        tree = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int value = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[value].add(new Node(next, weight));
            tree[next].add(new Node(value, weight));
        }

        visited = new boolean[n+1];
        dfs(1, 0);

        visited = new boolean[n+1];
        maxDistance = 0;
        dfs(farNode, 0);

        bw.write(maxDistance + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}