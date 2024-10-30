import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> intList = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            intList.add(Integer.parseInt(st.nextToken()));
        }

        int max = intList.get(0);
        int min = intList.get(0);

        for(int i = 1; i < intList.size(); i++) {

            if(intList.get(i) > max) {
                max = intList.get(i);
            }

            if(intList.get(i) < min) {
                min = intList.get(i);
            }
        }

        bw.write(min + " " + max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}