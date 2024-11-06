import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken()) -1;
        int index = count;

        List<Integer> intList = new ArrayList<>();

        for(int i = 1; i<=n; i++) {
            intList.add(i);
        }

        bw.write("<");

        while(intList.size() > 1) {

            while(index >= intList.size()) {
                index = index - (intList.size());
            }

            bw.write(intList.get(index) + ", ");
            intList.remove(index);

            index += count;

        }
        bw.write(intList.get(0) + "");
        bw.write(">");

        bw.flush();
        br.close();
        bw.close();
    }
}
