import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> intList = new ArrayList<>();
        int result = 1;

        for(int i = 0; i< 10; i++) {
            int a = Integer.parseInt(br.readLine()) % 42;
            intList.add(a);
        }

        intList.sort(Integer::compareTo);

        for(int i = 1; i< intList.size(); i++) {
            if(!intList.get(i-1).equals(intList.get(i))) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}