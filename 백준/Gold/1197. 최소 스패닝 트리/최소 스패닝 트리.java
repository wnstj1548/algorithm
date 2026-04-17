import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int v, e;
    static List<Edge> edges = new ArrayList<>();
    static int[] parents;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return false;

        parents[pb] = pa;
        return true;
    }

    public static void main(String[] args) throws Exception {

        v = nextInt();
        e = nextInt();

        parents = new int[v + 1];

        for(int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < e; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();

            edges.add(new Edge(a,b,c));
        }

        Collections.sort(edges);

        long sum = 0;
        int cnt = 0;

        for(Edge edge : edges) {
            if(union(edge.from, edge.to)) {
                sum += edge.cost;
                cnt++;

                if(cnt == v - 1) break;
            }
        }

        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}