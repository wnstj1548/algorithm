import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] array = br.readLine().toUpperCase().toCharArray();

        Map<Character, Integer> alphabetMap = new HashMap<>();
        List<Character> charList = new ArrayList<>();

        for(char c = 'A'; c <='Z'; c++) {
            alphabetMap.put(c, 0);
        }

        for(char a : array) {
            alphabetMap.put(a, alphabetMap.get(a) + 1);
        }

        int max = 0;

        for(int value : alphabetMap.values()) {
            max = Math.max(value, max);
        }

        for(char c = 'A'; c <='Z'; c++) {
            if(max == alphabetMap.get(c)) {
                charList.add(c);
            }
        }

        if(charList.size() > 1) {
            bw.write("?\n");
        } else {
            bw.write(charList.get(0));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


