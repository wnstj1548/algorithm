import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<int[]> graph = new ArrayList<>();

    public static void bfs(int remove) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(remove);

        while(!queue.isEmpty()) {
            int nowRemove = queue.poll();
            graph.removeIf(i -> {
                if (i[0] == nowRemove) {
                    queue.add(i[1]);
                    return true;
                }
                if (i[1] == nowRemove) {
                    return true;
                }
                return false;
            });
        }
    }

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = -1;
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp == -1) root = i;
            int[] edge = new int[]{temp, i};
            graph.add(edge);
        }

        int remove = Integer.parseInt(br.readLine());

        if(remove == root) {
            bw.write("0");
            bw.newLine();
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        bfs(remove);

        int count = 0;
        Set<Integer> parents = new HashSet<>();
        for(int[] i : graph) {
            parents.add(i[0]);
        }

        for(int[] i : graph) {
            if(!parents.contains(i[1])) count++;
        }

        bw.write(count + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}