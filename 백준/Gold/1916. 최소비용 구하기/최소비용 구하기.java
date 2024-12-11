import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dist;
    static List<List<Node>> graph;

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[n];
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node node : graph.get(cur)) {

                    if(!visited[node.end] && dist[cur] + node.cost < dist[node.end]) {
                        dist[node.end] = dist[cur] + node.cost;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) -1;
            int end = Integer.parseInt(st.nextToken()) -1;
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) -1;
        int end = Integer.parseInt(st.nextToken()) -1;

        dijkstra(start);

        bw.write(dist[end] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}