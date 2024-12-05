import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static BufferedWriter bw;

    public static void dfs(int depth, int start, int[] temp, boolean[] visited) throws IOException {

        if(depth == m) {
            for(int i : temp) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = start; i < arr.length; i++) {

            if(!visited[i] && i == 0) {
                visited[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1, i+1 ,temp, visited);
                visited[i] = false;
            } else if(!visited[i] && (arr[i-1] != arr[i] || visited[i-1])) {
                visited[i] = true;
                temp[depth] = arr[i];
                dfs(depth + 1, i+1 ,temp, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int[] temp = new int[m];
        boolean[] visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0 ,temp, visited);

        bw.flush();
        bw.close();
        br.close();
    }
}
