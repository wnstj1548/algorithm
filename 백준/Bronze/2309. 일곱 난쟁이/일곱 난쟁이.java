import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;

        List<Integer> intList = new ArrayList<>();

        for(int i = 0; i<9; i++) {
            int n = Integer.parseInt(br.readLine());

            sum += n;
            intList.add(n);
        }

        sum -= 100;
        boolean found = false;

        for(int i = 0; i<intList.size(); i++) {
            for(int j = i+1; j<intList.size(); j++) {
                if(intList.get(i) + intList.get(j) == sum) {
                    intList.remove(j);
                    intList.remove(i);
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        Collections.sort(intList);

        if(intList.size() == 7) {
            for(int i : intList) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
