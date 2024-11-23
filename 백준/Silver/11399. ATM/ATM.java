import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> intList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            intList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(intList);

        int sum = 0;
        int result = 0;

        for(int i : intList) {
            sum += i;
            result += sum;
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}