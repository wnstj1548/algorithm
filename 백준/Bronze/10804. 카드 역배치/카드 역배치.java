import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] intArray = new int[20];

        for(int i = 0; i < 20; i++) {
            intArray[i] = i+1;
        }

        for(int i = 0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            reverse(intArray, n, m);
        }

        for(int i : intArray) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void change(int[] arr, int i, int j) {
        int temp = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {

        int a = (end - start + 1) / 2;

        for(int i = 0; i < a; i++) {
            change(arr, start+i, end-i);
        }
    }
}
