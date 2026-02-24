import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        int now = 1;
        int start = 1;
        int end = now + m -1;

        int j = Integer.parseInt(br.readLine());

        for(int i = 0; i < j; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a >= start && a <= end) continue;
            if(a > end) {
                int pos = a - end;
                start += pos;
                end += pos;
                sum += pos;
            } else {
                int pos = a - start;
                start += pos;
                end += pos;
                sum += Math.abs(pos);
            }
        }

        bw.write(sum + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}