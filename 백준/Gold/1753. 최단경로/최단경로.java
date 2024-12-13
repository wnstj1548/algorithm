import java.io.*;
import java.util.*;

public class Main {

    static List<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    static int v,e,k;

    static class Node implements Comparable<Node> {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        visited = new boolean[v+1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nowValue = cur.value;
            int nowWeight = cur.weight;

            if(!visited[nowValue]) {
                visited[nowValue] = true;

                for(Node node : graph[nowValue]) {
                    if(!visited[node.value] && dist[nowValue] + node.weight < dist[node.value]) {
                        pq.add(new Node(node.value, nowWeight + node.weight));
                        dist[node.value] = nowWeight + node.weight;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        graph = new List[v+1];

        for(int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(k);

        for(int i =1; i <= v; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}