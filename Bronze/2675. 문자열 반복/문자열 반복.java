import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char[] charArray = st.nextToken().toCharArray();

            for(char c : charArray) {
                for(int j = 0; j<a; j++) {
                    bw.write(String.valueOf(c));
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}