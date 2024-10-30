import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        List<Integer> intList = new ArrayList<>();

        for(int i = 0; i < count; i++) {

            int a = Integer.parseInt(st1.nextToken());

            if(min > a) {
                intList.add(a);
            }
        }

        for(Integer i : intList) {
            bw.write(i + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();

    }
}