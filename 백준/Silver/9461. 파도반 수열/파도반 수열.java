import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[101];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        for(int i = 6; i <= 100; i++) {
            arr[i] = arr[i-1] + arr[i-5];
        }

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            bw.write(arr[a] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}