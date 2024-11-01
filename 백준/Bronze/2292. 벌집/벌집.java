import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine()) -2;
        int i = 1;
        int result = 1;

        if(n == -1) {
            result = 1;
        }

        while(n >= 0) {
            n = n -6*i;
            i++;
            result++;
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}