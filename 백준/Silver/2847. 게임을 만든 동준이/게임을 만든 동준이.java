import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = n-2; i >=0; i--) {
            while(arr[i] >= arr[i+1]) {
                arr[i] = arr[i] -1;
                count++;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
