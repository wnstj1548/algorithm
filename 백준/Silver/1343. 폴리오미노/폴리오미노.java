import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] splitString = input.split("\\.", -1);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < splitString.length; i++) {

            String s = splitString[i];

            if(s.length() % 2 != 0) {
                sb = new StringBuilder().append("-1\n");
                break;
            }

            while(s.length() >= 4) {
                sb.append("AAAA");
                s = s.substring(4);
            }

            while(s.length() == 2) {
                sb.append("BB");
                s = s.substring(2);
            }

            if(i < splitString.length - 1) {
                sb.append(".");
            }
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
