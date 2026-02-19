import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            for(int ii = 0; ii < k; ii++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String type = st.nextToken();

                map.putIfAbsent(type, 1);
                map.put(type, map.get(type) + 1);
            }

            int out = 1;

            for(String key : map.keySet()) {
                out = out * map.get(key);
            }

            bw.write((out -1) + "");
            bw.newLine();
            map.clear();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}