import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        if(n < m) {
            bw.write(m-n-1 + "\n");

            for(long i = n + 1; i<m; i++) {
                bw.write(i + " ");
            }
        } else if(n > m) {
            bw.write(n-m-1 + "\n");

            for(long i = m +1; i<n; i++) {
                bw.write(i + " ");
            }
        } else if(n == m) {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
