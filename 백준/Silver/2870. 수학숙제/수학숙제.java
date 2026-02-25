import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            for(char c : s.toCharArray()) {
                if(Character.isDigit(c)) {
                    sb.append(c - '0');
                } else {
                    if(sb.length() > 0) {
                        list.add(normalize(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }

            if(sb.length() > 0) {
                list.add(normalize(sb.toString()));
                sb.setLength(0);
            }
        }

        Collections.sort(list, (a, b) -> {
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        for(String s : list) {
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String normalize(String s) {
        int i = 0;
        while(s.length() -1 > i && s.charAt(i) == '0') i++;
        return s.substring(i);
    }
}