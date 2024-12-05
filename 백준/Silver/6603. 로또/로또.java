import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static BufferedWriter bw;

    public static void dfs(int depth, int[] temp, boolean[] visited, int start) throws IOException {

        if(depth == 6) {
            for(int i = 0; i < 6; i++) {
                bw.write(temp[i] + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = start; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                dfs(depth+1, temp, visited, i+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        while(!s.equals("0")) {
            StringTokenizer st = new StringTokenizer(s);

            n = Integer.parseInt(st.nextToken());
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[n];

            dfs(0, new int[6], visited, 0);

            bw.newLine();
            s = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
