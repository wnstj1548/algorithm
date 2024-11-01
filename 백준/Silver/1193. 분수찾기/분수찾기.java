import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int line = 1;

        while(n > 0) {
            n = n - line;
            line ++;
        }

        line = line -1;
        n += line;

        if(line%2 == 0) {
            bw.write((n) + "/" + (line + 1 - n) + "\n");
        } else {
            bw.write((line + 1 - n) + "/" + (n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
