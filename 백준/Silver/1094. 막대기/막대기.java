import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int ret = 0;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        while(n > 0) {
            if((n & 1) == 1) ret++;
            n /= 2;
        }

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}