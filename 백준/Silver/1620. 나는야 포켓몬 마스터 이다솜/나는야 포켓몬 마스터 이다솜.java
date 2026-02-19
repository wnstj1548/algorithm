import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n+1];
        Map<String, Integer> map = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();

            arr[i] = s;
            map.put(s, i);
        }

        for(int i = 0; i < m; i++) {
            String s = br.readLine();

            boolean isDigit = true;

            for(char c : s.toCharArray()) {
                if(!Character.isDigit(c)) {
                    isDigit = false;
                }
            }

            if(isDigit) {
                int index = Integer.parseInt(s);
                bw.write(arr[index]);
                bw.newLine();
            } else {
                int index = map.get(s);
                bw.write(index + "");
                bw.newLine();
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}