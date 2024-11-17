import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] result = new int[1001];

        result[0] = 0;
        result[1] = 1;
        result[2] = 2;

        for(int i = 3; i <= n; i++) {
            result[i] = (result[i-1] + result[i-2]) % 10007;
        }

        bw.write(result[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}