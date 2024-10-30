import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i<n; i++) {
            arr[i] = i + 1;
        }

        for(int a = 0; a < m; a++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st1.nextToken());
            int j = Integer.parseInt(st1.nextToken());

            reverse(arr, i -1, j -1);
        }

        for(int i : arr) {
            bw.write(i + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void reverse(int[] arr, int i, int j) {
        for(int k = 0; k < (j-i+1)/2; k++) {
            swap(arr, i+k, j-k);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}