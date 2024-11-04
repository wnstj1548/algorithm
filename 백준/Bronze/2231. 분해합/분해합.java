import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> intList = new ArrayList<>();

        int count = 0;
        int n1 = n;

        while(n1 != 0) {
            n1/= 10;
            count++;
        }

        for(int i = n - (count * 9); i < n; i++) {

            int number = i;

            int sum = 0;

            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == n) {
                intList.add(i);
                break;
            }
        }

        bw.write(!intList.isEmpty() ? intList.get(0).toString() : "0");
        bw.flush();
        bw.close();
    }
}