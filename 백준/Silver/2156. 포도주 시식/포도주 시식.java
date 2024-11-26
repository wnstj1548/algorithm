import java.io.*;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {
            bw.write(arr[0] + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        result[0] = arr[0];
        result[1] = arr[0] + arr[1];

        if(n == 2) {
            bw.write(result[1] + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        result[2] = Math.max(result[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

        if(n == 3) {
            bw.write(result[2] + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }


        for(int i = 3; i < n; i++) {
            result[i] = Math.max(result[i-1], Math.max(result[i-2] + arr[i], arr[i-1] + result[i-3] + arr[i]));
        }

        bw.write(result[n-1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}