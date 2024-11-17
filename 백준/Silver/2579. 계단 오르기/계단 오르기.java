import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] result = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        result[0] = 0;
        result[1] = arr[1];

        if(n >= 2) {
            result[2] = arr[1] + arr[2];
        }

        for(int i = 3; i <=n; i++) {
            result[i] = Math.max(result[i-2], result[i-3] + arr[i-1]) + arr[i];
        }

        bw.write(result[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}