import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;

        while((line = br.readLine()) != null && !line.isEmpty()) {

            StringTokenizer st = new StringTokenizer(line);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write((n+m)+ "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}