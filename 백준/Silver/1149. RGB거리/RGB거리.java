import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][n + 1];
        int[][] result = new int[3][n + 1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            arr[2][i] = Integer.parseInt(st.nextToken());
        }

        result[0][1] = arr[0][1];
        result[1][1] = arr[1][1];
        result[2][1] = arr[2][1];

        for(int i = 2; i <= n; i++) {
            result[0][i] = Math.min(result[1][i-1], result[2][i-1]) + arr[0][i];
            result[1][i] = Math.min(result[0][i-1], result[2][i-1]) + arr[1][i];
            result[2][i] = Math.min(result[0][i-1], result[1][i-1]) + arr[2][i];
        }

        int a = Math.min(result[0][n], Math.min(result[1][n], result[2][n]));

        bw.write(a + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}