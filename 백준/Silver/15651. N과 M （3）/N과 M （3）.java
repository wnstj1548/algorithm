import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int[] arr;
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

        for(int i = 1; i <= n; i++) {
                arr[depth] = i;
                dfs(n, m, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dfs(n,m,0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}