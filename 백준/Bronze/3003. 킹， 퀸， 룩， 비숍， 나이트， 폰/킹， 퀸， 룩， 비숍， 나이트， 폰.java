import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> total = new ArrayList<>(Arrays.asList(1,1,2,2,2,8));
        List<Integer> intList = new ArrayList<>();

        while(st.hasMoreTokens()) {
            intList.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < intList.size(); i++) {
            bw.write(total.get(i) - intList.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}