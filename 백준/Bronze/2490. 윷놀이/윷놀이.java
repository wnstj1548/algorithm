import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int j = 0; j<3; j++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int backCount = 0;

            for(int i =0; i<4; i++) {
                if(st.nextToken().equals("1")) {
                    backCount++;
                }
            }

            if(backCount == 4) {
                bw.write("E\n");
            } else if(backCount == 3) {
                bw.write("A\n");
            } else if(backCount == 2) {
                bw.write("B\n");
            } else if(backCount == 1) {
                bw.write("C\n");
            } else if(backCount == 0) {
                bw.write("D\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
