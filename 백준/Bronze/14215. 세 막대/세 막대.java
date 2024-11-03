import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int max = Math.max(x, Math.max(y, z));
        int sum;

        if(max == x) {
            if(y + z <= max) {
                max = y + z - 1;
            }
            sum = max + y + z;
        } else if (max == y) {
            if(x + z <= max) {
                max = x + z - 1;
            }
            sum = max + x + z;
        } else {
            if(x + y <= max) {
                max = x + y - 1;
            }
            sum = max + x + y;
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}