import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sumM = 0;
        int sumY = 0;

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            sumY += ((a / 30) + 1) * 10;
            sumM += ((a / 60) + 1) * 15;
        }

        if(sumM < sumY) {
            bw.write("M " +sumM + "\n");
        } else if(sumY < sumM) {
            bw.write("Y " +sumY + "\n");
        } else {
            bw.write("Y M " + sumM +"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
