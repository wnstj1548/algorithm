import java.io.*;
import java.util.*;

public class Main {

    static List<List<int[]>> node;
    static int[] item;
    static int n, m, r;
    static boolean[] visited;
    static int[] distance;

    public static int dijkstra(int start) {

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        int max = 0;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int current = now[0];
            int dist = now[1];

            if(!visited[current]) {
                visited[current] = true;

                for(int[] temp : node.get(current)) {
                    int other = temp[0];
                    int weight = temp[1];

                    if(distance[other] > dist + weight) {
                        distance[other] = dist + weight;
                        pq.add(new int[]{other, distance[other]});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] <= m) {
                max += item[i];
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n];
        node = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            node.add(new ArrayList<>());
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken());

            node.get(a).add(new int[]{b,c});
            node.get(b).add(new int[]{a,c});
        }

        distance = new int[n];
        visited = new boolean[n];

        int max = 0;

        for(int i = 0; i < n; i++) {
            max = Math.max(max, dijkstra(i));
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}