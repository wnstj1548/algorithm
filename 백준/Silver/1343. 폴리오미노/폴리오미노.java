import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        s = s.replace("XXXX", "AAAA");
        s = s.replace("XX", "BB");

        if(s.contains("X")) {
            bw.write("-1");
        } else {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
