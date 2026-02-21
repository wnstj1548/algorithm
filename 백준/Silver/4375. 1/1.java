import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "";

        while((s = br.readLine()) != null) {
            s = s.trim();
            if(s.isEmpty()) continue;

            int n = Integer.parseInt(s);

            if(n == 1) {
                bw.write("1");
                bw.newLine();
                continue;
            }

            int num = 11;
            int count = 2;

            while(true) {
                num = num % n;

                if(num == 0) {
                    bw.write(count + "");
                    bw.newLine();
                    break;
                }

                num = num * 10 + 1;
                count++;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}