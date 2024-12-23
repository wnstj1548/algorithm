import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int first = 2;

        for(int i = 0; i < n; i++) {
            first = first * 2 - 1;
        }

        bw.write((int)Math.pow(first, 2) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}