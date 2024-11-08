import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;

        List<Integer> intList = new ArrayList<>();

        for(int i = 0; i<5; i++) {
            int n = Integer.parseInt(br.readLine());

            sum += n;
            intList.add(n);
        }

        Collections.sort(intList);


        bw.write((int)(sum/5) + "\n");
        bw.write(intList.get(2) + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
