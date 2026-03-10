import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        String s = br.readLine();

        int i = 0;
        boolean ok = true;

        while(i < s.length()) {
            if(i+1 < s.length() && s.startsWith("pi", i)) {
               i += 2;
            } else if(i+1 < s.length() && s.startsWith("ka", i)) {
                i += 2;
            } else if(i+2 < s.length() && s.startsWith("chu", i)) {
                i += 3;
            } else {
                ok = false;
                break;
            }
        }

        String res = ok ? "YES" : "NO";

        bw.write(res);
        bw.flush();
        bw.close();
        br.close();
    }
}