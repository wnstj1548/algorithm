import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        boolean plus = true;
        int sum = 0;

        while(s.contains("-")) {

            String front = s.substring(0, s.indexOf("-"));

            StringTokenizer st = new StringTokenizer(front, "+");

            while(st.hasMoreTokens()) {
                if(plus) {
                    sum += Integer.parseInt(st.nextToken());
                } else {
                    sum -= Integer.parseInt(st.nextToken());
                }
            }

            s = s.substring(s.indexOf("-")+1);
            plus = false;
        }

        StringTokenizer st = new StringTokenizer(s, "+");

        while(st.hasMoreTokens()) {
            if(plus) {
                sum += Integer.parseInt(st.nextToken());
            } else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}