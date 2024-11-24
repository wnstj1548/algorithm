import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> intList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            intList.add(temp);
        }

        Collections.sort(intList);

        int max = 0;

        for(int i = n-1; i >= 0; i--) {
            max = Math.max(intList.get(i) * (n-i), max);
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}