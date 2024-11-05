import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int three = 0;
        int five = 0;
        List<Integer> intList = new ArrayList<>();

        if(n % 5 == 0) {
            five = n/5;
            intList.add(five + three);
        } else if (n % 3 == 0) {
            three = n/3;

            while(three > 5) {
                three -= 5;
                five += 3;
            }

            intList.add(five + three);
        } else {
            for(int i = n/5; i >= 0; i--) {
                for(int j = n/3; j >= 0; j--) {
                    if(n == (5 * i) + (3 * j)) {
                        five = i;
                        three = j;
                        intList.add(five + three);
                    }
                }
            }
        }

        if(five + three == 0) {
            bw.write("-1\n");
        } else {
            bw.write(intList.stream().sorted().collect(Collectors.toList()).get(0) +"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
