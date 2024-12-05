import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static BufferedWriter bw;

    public static void dfs(int depth, int[] temp) throws IOException {

        if(depth == m) {
            for(int i : temp) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = 0; i < arr.length; i++) {

            if(i == 0) {
                temp[depth] = arr[i];
                dfs(depth + 1,temp);
            } else if(arr[i-1] != arr[i]) {
                temp[depth] = arr[i];
                dfs(depth + 1,temp);
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

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0 ,temp);

        bw.flush();
        bw.close();
        br.close();
    }
}
