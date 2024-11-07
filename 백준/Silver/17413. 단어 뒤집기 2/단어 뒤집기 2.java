import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        boolean isTag = false;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '<') {

                if(temp.length() > 0) {
                    sb.append(temp.reverse());
                    temp = new StringBuilder();
                }

                isTag = true;
                sb.append("<");

            } else if(s.charAt(i) == '>') {
                isTag = false;
                sb.append(">");
            } else if(isTag) {
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == ' ') {
                sb.append(temp.reverse()).append(" ");
                temp = new StringBuilder();
            } else {
                temp.append(s.charAt(i));
            }
        }

        if(temp.length() > 0) {
            sb.append(temp.reverse());
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
