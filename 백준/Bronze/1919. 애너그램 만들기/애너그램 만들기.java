import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int count = 0;

        String s1 = br.readLine();
        String s2 = br.readLine();

        for(int j =0; j<s1.length(); j++) {
            map.put(s1.charAt(j), map.getOrDefault(s1.charAt(j), 0) + 1);
        }

        for(int j = 0; j<s2.length(); j++) {
            map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        String s3 = s1 + s2;
        s3 = s3.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.joining());

        for(int j = 0; j<s3.length(); j++) {

            int a = map2.getOrDefault(s3.charAt(j), 0);
            int b = map.getOrDefault(s3.charAt(j), 0);

            if(!Objects.equals(map2.get(s3.charAt(j)), map.get(s3.charAt(j)))) {
                count += Math.abs(a - b);
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
