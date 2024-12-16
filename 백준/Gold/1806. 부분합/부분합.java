import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int front = 1;
        int back = 1;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while(front <= back && back <= n) {

            if(sum < s) {
                sum += arr[back];
                back++;
            } else {
                min = Math.min(min, back-front);
                sum -= arr[front];
                front++;
            }
        }

        while(sum >= s) {
            min = Math.min(min, back-front);
            sum -= arr[front];
            front++;
        }

        if(min == Integer.MAX_VALUE) {
            bw.write("0\n");
        } else {
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}