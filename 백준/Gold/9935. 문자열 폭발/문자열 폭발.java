import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        String s = br.readLine();
        String burst = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            sb.append(s.charAt(i));

            boolean same = false;

            if(burst.length() <= sb.length()) {

                same = true;

                for(int j = 0; j < burst.length(); j++) {
                    if (sb.charAt(sb.length() - burst.length() + j) != burst.charAt(j)) {
                        same = false;
                        break;
                    }
                }
            }

            if(same) {
                sb.setLength(sb.length() - burst.length());
            }
        }

        String res = sb.toString();

        bw.write(res.isBlank() ? "FRULA" : res);
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}