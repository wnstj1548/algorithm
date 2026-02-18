import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String regex = br.readLine().replace("*", ".*");


        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            if(s.matches(regex)) {
                bw.write("DA");
            } else {
                bw.write("NE");
            }

            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}