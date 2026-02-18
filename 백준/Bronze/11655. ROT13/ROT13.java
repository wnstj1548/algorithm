import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'm') {
                sb.append((char) (c + 13));
            } else if(c >= 'n' && c <= 'z') {
                sb.append((char) (c - 13));
            } else if(c >= 'A' && c <= 'M') {
                sb.append((char) (c + 13));
            } else if(c >= 'N' && c <= 'Z') {
                sb.append((char) (c - 13));
            } else {
                sb.append(c);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}