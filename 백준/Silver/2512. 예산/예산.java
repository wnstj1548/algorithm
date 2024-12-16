import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int min = 0;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());

        while(min <= max) {
            int mid = (min + max)/2;

            int sum = 0;

            for(int i = 0; i < n; i++) {
                if(arr[i] >= mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if (sum <= m) {
                min = mid + 1;
            } else {
                max = mid -1;
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}