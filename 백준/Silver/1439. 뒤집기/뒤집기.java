import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        String s = br.readLine();

        for(int i = 1 ; i < s.length() ; i++) {
            if(s.charAt(i-1) != s.charAt(i)) {
                count++;
            }
        }

        bw.write(count / 2 + count % 2 +"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}