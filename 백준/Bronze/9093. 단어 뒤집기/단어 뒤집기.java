import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                bw.write(reverse(st.nextToken()));
                bw.write(" ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static String reverse(String s) {
        return new StringBuilder()
                .append(s)
                .reverse()
                .toString()
                .trim();
    }
}