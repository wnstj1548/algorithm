import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a;

        while((a = Integer.parseInt(br.readLine())) != -1) {

            List<Integer> intList = new ArrayList<>();

            for (int i = 1; i < a; i++) {
                if (a % i == 0) {
                    intList.add(i);
                }
            }

            int sum = 0;

            for(int i : intList) {
                sum += i;
            }

            if(a == sum) {
                bw.write(a + " = ");
                for(int j =0; j<intList.size()-1; j++) {
                    bw.write(intList.get(j) + " + ");
                }
                bw.write(intList.get(intList.size()-1) + "\n");
            } else {
                bw.write(a + " is NOT perfect.\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();

    }
}
