import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            if(isGroup(br.readLine().toCharArray())) {
                sum += 1;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isGroup(char[] array) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c = 'a'; c <= 'z'; c++) {
            map.put(c, 0);
        }

        for(int i = 1; i < array.length; i++) {
            if(!String.valueOf(array[i-1]).equals(String.valueOf(array[i]))) {
                map.put(array[i-1], map.get(array[i-1]) + 1);
            }
        }

        map.put(array[array.length -1 ], map.get(array[array.length - 1]) + 1);

        for(char c = 'a'; c <= 'z'; c++) {
            if(map.get(c) > 1) {
                return false;
            }
        }

        return true;
    }
}


