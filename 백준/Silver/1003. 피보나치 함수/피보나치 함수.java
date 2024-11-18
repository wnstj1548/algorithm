import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> intList = new ArrayList<>();

        for(int i = 0 ; i<n; i++) {
            int temp = Integer.parseInt(br.readLine());
            intList.add(temp);
        }

        int[] zeroCount = new int[41];
        int[] oneCount = new int[41];

        zeroCount[0] = 1;
        zeroCount[1] = 0;
        oneCount[0] = 0;
        oneCount[1] = 1;

        for(int i = 2; i <= 40; i++) {
            zeroCount[i] = zeroCount[i-1] + zeroCount[i-2];
            oneCount[i] = oneCount[i-1] + oneCount[i-2];
        }

        for(int i : intList) {
            bw.write(zeroCount[i] + " " + oneCount[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}