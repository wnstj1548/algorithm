import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            freq.put(num, freq.getOrDefault(num, 0) + 1);
            first.putIfAbsent(num, i);
        }

        List<Integer> freqList = new ArrayList<>(freq.keySet());

        freqList.sort((a, b) -> {
            if(Objects.equals(freq.get(a), freq.get(b))) {
                return first.get(a) - first.get(b);
            }

            return freq.get(b) - freq.get(a);
        });

        for(int result : freqList) {
            for(int i = 0; i < freq.get(result); i++) {
                bw.write(result + " ");
            }
        }

        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}