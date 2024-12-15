import java.io.*;
import java.util.*;

public class Main {

    static int[] dist;
    static List<Node>[] graphs;
    static boolean[] visited;
    static int IMP = 100000000;

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

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, IMP);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        Arrays.fill(visited, false);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visited[cur.value]) {
                visited[cur.value] = true;

                for(Node n : graphs[cur.value]) {
                    if(!visited[n.value] && dist[cur.value] + n.weight < dist[n.value]) {
                        dist[n.value] = dist[cur.value] + n.weight;
                        pq.add(new Node(n.value, dist[n.value]));
                    }
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graphs= new List[n];

        for(int i = 0; i < n; i++){
            graphs[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken());

            graphs[a].add(new Node(b, c));
            graphs[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        dist = new int[n];
        visited = new boolean[n];

        int value1 = Integer.parseInt(st.nextToken()) -1;
        int value2 = Integer.parseInt(st.nextToken()) -1;

        int result1 = 0;
        result1 += dijkstra(0, value1);
        result1 += dijkstra(value1, value2);
        result1 += dijkstra(value2, n-1);

        int result2 = 0;
        result2 += dijkstra(0, value2);
        result2 += dijkstra(value2, value1);
        result2 += dijkstra(value1, n-1);

        int result = Math.min(result1, result2);

        if(result >= IMP) {
            bw.write("-1\n");
        } else {
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}