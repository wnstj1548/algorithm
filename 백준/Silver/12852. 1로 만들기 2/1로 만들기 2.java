import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] result = new int[n+1];
        int[] before = new int[n+1];

        result[0] = result[1] = 0;

        for(int i = 2; i <= n; i++) {

            result[i] = result[i-1] + 1;
            before[i] = i-1;

            if (i % 3 == 0 && result[i/3] + 1 < result[i]) {
                result[i] = result[i/3] + 1;
                before[i] = i/3;
            }

            if (i % 2 == 0 && result[i/2] + 1 < result[i]) {
                result[i] = result[i/2] + 1;
                before[i] = i/2;
            }
        }

        bw.write(result[n] + "\n");

        String str = "";
        while(n > 0) {
            str += n + " ";
            n = before[n];
        }
        bw.write(str);

        bw.flush();
        bw.close();
        br.close();
    }
}