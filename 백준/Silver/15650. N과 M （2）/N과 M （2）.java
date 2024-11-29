import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int n, int m, int depth) {

        if(depth == m) {
            for(int i : arr) {
                if(i !=0) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(depth == 0) {
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(n, m, depth + 1);
                    visited[i] = false;
                } else if(arr[depth-1] <= i) {
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(n, m, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        dfs(n,m,0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}