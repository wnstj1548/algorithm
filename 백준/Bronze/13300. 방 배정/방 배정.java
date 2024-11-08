import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        int count = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st1.nextToken());
            int grade = Integer.parseInt(st1.nextToken());

            map.put(grade + " " + gender, map.getOrDefault(grade + " " + gender, 0) + 1);
        }

        for(int i : map.values()) {
            int temp = i%k == 0 ? i/k : i/k + 1;
            count += temp;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
