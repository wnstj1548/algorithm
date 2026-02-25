import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) throws IOException {

        String s;

        while((s = br.readLine()) != null) {

            if("end".equals(s)) break;

            StringBuilder sb = new StringBuilder();
            int vowelCount = 0;
            int continuousCount = 1;
            char lastChar = s.charAt(0);
            boolean isAcceptable = true;
            boolean isFirst = true;

            for(char c : s.toCharArray()) {

                if (isVowel(c)) {
                    vowelCount += 1;

                    if(isVowel(lastChar)) {
                        continuousCount += 1;
                    } else {
                        continuousCount = 1;
                    }
                } else {
                    if(!isVowel(lastChar)) {
                        continuousCount += 1;
                    } else {
                        continuousCount = 1;
                    }
                }

                if(isFirst) {
                    continuousCount = 1;
                    isFirst = false;
                    continue;
                }

                if(lastChar == c) {
                    if(c != 'e' && c != 'o') isAcceptable = false;
                }

                if(continuousCount >= 3) {
                    isAcceptable = false;
                }

                lastChar = c;
            }

            if(vowelCount == 0) {
                isAcceptable = false;
            }

            sb.append("<");
            sb.append(s);
            sb.append("> is ");

            if(!isAcceptable) {
               sb.append("not ");
            }

            sb.append("acceptable.\n");
            bw.write(sb.toString());
            bw.flush();
        }

        bw.close();
        br.close();
    }
}