import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] temp = new int[n+1];
        int max = 0;

        for(int i = 1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= i; j++) {
                int a = Integer.parseInt(st.nextToken());
                temp[j] = Math.max(arr[j], arr[j-1]) + a;
            }

            for(int j = 1; j <= i; j++) {
                arr[j] = temp[j];
            }
        }

        for(int i : arr) {
            if(max < i) {
                max = i;
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}