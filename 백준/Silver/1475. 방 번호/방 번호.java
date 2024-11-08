import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Map<Character, Integer> intMap = new HashMap<>();

        for(char c = '0'; c <= '8'; c++) {
            intMap.put(c, 0);
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '9') {
                c = '6';
            }
            intMap.put(c, intMap.get(c) + 1);
        }

        intMap.put('6', intMap.get('6') % 2 == 1 ? intMap.get('6') / 2 + 1 : intMap.get('6') / 2);

        int max = 0;

        for(int i : intMap.values()) {
            if(i > max) {
                max = i;
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
