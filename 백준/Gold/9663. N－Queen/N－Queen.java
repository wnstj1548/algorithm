import java.io.*;

public class Main {

    static int[] arr;
    static int n;
    static int count;

    static void dfs(int depth) {

        if(depth == n) {
            count++;
            return;
        }

        for(int i = 0; i < n; i++) {
            arr[depth] = i;

            if(isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean isPossible(int depth) {

        for(int i = 0; i < depth; i++) {
            if(arr[depth] == arr[i]) {
                return false;
            }

            if(Math.abs(arr[depth] - arr[i]) == Math.abs(depth - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        count = 0;

        dfs(0);

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
