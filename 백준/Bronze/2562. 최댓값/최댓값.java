import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int index = 1;
        int max = Integer.parseInt(br.readLine());

        for(int i = 2; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a > max) {
                max = a;
                index = i;
            }
        }

        bw.write(max + "\n" + index + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}