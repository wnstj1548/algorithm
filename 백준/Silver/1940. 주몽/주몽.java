import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[10000001];

        while(st.hasMoreTokens()) {
            int material = Integer.parseInt(st.nextToken());
            arr[material]++;
        }

        for(int i = 1; i < (m+1) / 2; i++) {
            if(m - i > 0 && arr[i] > 0 && arr[m-i] > 0) {
                count++;
            }
        }

        bw.write(count + "");

        bw.flush();
        br.close();
        bw.close();
    }
}