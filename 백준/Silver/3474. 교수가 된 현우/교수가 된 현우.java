import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int two = 0;
            int five = 0;

            for(int j = 2; j <= num; j*=2) {
                two += num/j;
            }

            for(int j = 5; j <= num; j*=5) {
                five += num/j;
            }

            bw.write(Math.min(two, five) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}