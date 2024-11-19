import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = arr[0];
        int max = result[0];

        for(int i = 1; i < n; i++) {
            result[i] = Math.max(result[i-1] + arr[i], arr[i]);
            max = Math.max(max, result[i]);
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}