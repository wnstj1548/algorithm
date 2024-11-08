import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> charMap = new HashMap<>();

        String s = br.readLine();

        for(char c = 'a'; c <= 'z'; c++) {
            charMap.put(c, 0);
        }

        for(int i = 0; i<s.length(); i++) {
            charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
        }

        for(int i : charMap.values()) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
