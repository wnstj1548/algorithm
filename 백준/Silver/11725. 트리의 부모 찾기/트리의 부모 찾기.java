import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n -1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int node : tree.get(now)) {
                if(!visited[node]) {
                    visited[node] = true;
                    parent[node] = now;
                    queue.add(node);
                }
            }
        }

        for(int i = 1; i < n; i++) {
            bw.write(parent[i] + 1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}