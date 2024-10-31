import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        String reverse = sb.append(s).reverse().toString();

        if(s.equals(reverse)) {
            bw.write("1");
        } else {
            bw.write("0");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}


