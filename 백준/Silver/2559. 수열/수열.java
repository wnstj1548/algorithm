import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int sum = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= k; i++) {
            sum += arr[i];
        }

        max = sum;

        for(int i = 1; i <= n-k; i++) {
            sum -= arr[i];
            sum += arr[i+k];
            if(sum > max) {
                max = sum;
            }
        }

        bw.write(max+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}