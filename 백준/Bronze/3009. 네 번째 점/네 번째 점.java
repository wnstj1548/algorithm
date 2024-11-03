import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> xMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> yMap = new HashMap<Integer, Integer>();

        for(int i =0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        for(Integer i : xMap.keySet()) {
            if(xMap.get(i) == 1) {
                bw.write(i + " ");
            }
        }

        for(Integer i : yMap.keySet()) {
            if(yMap.get(i) == 1) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}