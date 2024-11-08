import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;

        List<Integer> intList = new ArrayList<>();

        for(int i = 0; i<7; i++) {

            int n = Integer.parseInt(br.readLine());
                    
            if(n % 2 == 1) {
                intList.add(n);
            }
        }

        Collections.sort(intList);

        if(intList.isEmpty()) {
            bw.write("-1\n");
        } else {
            for(int i : intList) {
                sum += i;
            }
            bw.write(sum + "\n");
            bw.write(intList.get(0) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
