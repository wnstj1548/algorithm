import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[] praise;

    static void dfs(int now) {

        for(int i : graph[now]) {
            praise[i] += praise[now];
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        praise = new int[n+1];

        for(int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for(int i = 2; i < n+1; i++) {
            graph[Integer.parseInt(st.nextToken())].add(i);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            praise[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        dfs(1);

        for(int i = 1; i <= n; i++) {
            bw.write(praise[i] + " ");
        }
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}