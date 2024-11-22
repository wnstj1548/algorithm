import java.io.*;
import java.util.*;

class Main {

    static boolean[] visited; //사이클 안
    static boolean[] finished; //사이클 밖
    static int[] arr;
    static int count;

    static void dfs(int x) {

        if(finished[x]) return;

        if(visited[x]) {
            finished[x] = true;
            count++;
        }

        visited[x] = true;

        dfs(arr[x]);

        visited[x] = false;
        finished[x] = true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            count = 0;
            int a = Integer.parseInt(br.readLine());
            arr = new int[a+1];
            visited = new boolean[a+1];
            finished = new boolean[a+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= a; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j <= a; j++) {
                if(!finished[j]) {
                    dfs(j);
                }
            }

            bw.write(a - count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}