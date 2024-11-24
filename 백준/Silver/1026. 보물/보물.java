import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            bList.add(Integer.parseInt(st.nextToken()));
        }


        Collections.sort(aList);
        bList.sort(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            sum += aList.get(i) * bList.get(i);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}