import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, sum, total;
    static int[] personArr;
    static List<Integer>[] graph;
    static int min = Integer.MAX_VALUE;
    static boolean[] selected;
    static boolean[] visited;

    public static boolean go() {

        int select = 0;
        int unselect = 0;

        for(int i = 1; i <= n; i++) {
            if(selected[i]) select = i;
            else unselect = i;
        }

        Arrays.fill(visited, false);
        dfs(select, true);

        for(int i = 1; i <= n; i++) {
            if(selected[i] && visited[i]) sum += personArr[i];
            if(selected[i] && !visited[i]) return false;
        }

        Arrays.fill(visited, false);
        dfs(unselect, false);

        for(int i = 1; i <= n; i++) {
            if(!selected[i] && !visited[i]) return false;
        }

        return true;
    }

    public static void dfs(int n, boolean flag) {

        visited[n] = true;

        for(int i : graph[n]) {
            if(visited[i]) continue;
            if(selected[i] != flag) continue;
            dfs(i, flag);
        }
    }

    public static void combi(int start, int depth, int max) {

        if(max == depth) {
            sum = 0;
            if(go()) {
                min = Math.min(min, Math.abs((total - sum) - sum));
            }
            return;
        }

        for(int i = start; i <= n; i++) {
            selected[i] = true;
            combi(i+1, depth + 1, max);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        graph = new List[n+1];
        personArr = new int[n+1];
        visited = new boolean[n+1];
        selected = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            personArr[i] = temp;
            total += temp;
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());

            for(int j = 0; j < temp; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i <= n/2; i++) {
            combi(1, 0, i);
        }

        bw.write(min == Integer.MAX_VALUE ? "-1" : min + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}