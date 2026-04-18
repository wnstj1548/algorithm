import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[] parents;
    static List<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int costs;

        public Edge(int from, int to, int costs) {
            this.from = from;
            this.to = to;
            this.costs = costs;
        }

        @Override
        public int compareTo(Edge o) {
            return this.costs - o.costs;
        }
    }

    static int find(int x) {
        if(parents[x] == x) return x;
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

        n = nextInt();
        m = nextInt();

        parents = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int a = nextInt() -1;
            int b = nextInt() -1;
            int c = nextInt();

            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for(Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                sum += edge.costs;
                cnt++;
                max = Math.max(max, edge.costs);

                if(cnt == n-1) break;
            }
        }

        bw.write(String.valueOf(sum - max));
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