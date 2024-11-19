import java.io.*;
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

        for(int i =0; i < n; i++) {
            result[i] = arr[i];
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    result[i] = Math.max(result[i], result[j] + arr[i]);
                }
            }
        }

        int max = 0;

        for(int i : result) {
            max = Math.max(max, i);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}