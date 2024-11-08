import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();

            for(int j =0; j<s1.length(); j++) {
                map.put(s1.charAt(j), map.getOrDefault(s1.charAt(j), 0) + 1);
            }

            for(int j = 0; j<s2.length(); j++) {
                map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
            }

            boolean impossible = false;

            for(int j = 0; j<s2.length(); j++) {
                if(!Objects.equals(map2.get(s2.charAt(j)), map.get(s2.charAt(j)))) {
                    bw.write("Impossible\n");
                    impossible = true;
                    break;
                }
            }

            if(!impossible) {
                bw.write("Possible\n");
            }

            map.clear();
            map2.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
