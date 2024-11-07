import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int open = 0;
        int close = 0;
        int count = 0;

        for (int i = 0; i< s.length(); i++) {

            if(s.charAt(i) == '(' && s.charAt(i+1) == ')') {
                i++;
                if(open > close) {
                    count += open - close;
                }
            } else if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
                count++;
            }

        }

        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
