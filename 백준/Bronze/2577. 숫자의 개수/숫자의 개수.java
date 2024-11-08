import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> intMap = new HashMap<>();

        long multi = 1;

        for(char c = '0'; c <= '9'; c++) {
            intMap.put(c, 0);
        }

        for(long i = 0; i < 3; i++) {
            long num = Long.parseLong(br.readLine());
            multi = multi * num;
        }

        String s = String.valueOf(multi);

        for(int i = 0; i < s.length(); i++) {
            intMap.put(s.charAt(i), intMap.get(s.charAt(i)) + 1);
        }

        for(int i : intMap.values()) {
            bw.write(i + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
