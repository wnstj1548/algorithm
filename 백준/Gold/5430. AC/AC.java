import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++) {

            String s1 = br.readLine();
            int m = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> intList = new LinkedList<>();

            for(int j=0; j<m; j++) {
                intList.add(Integer.parseInt(st.nextToken()));
            }

            bw.write(start(s1, intList));

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String start(String s, Deque<Integer> intList) {

        boolean reverse = false;
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j<s.length(); j++) {
            if(s.charAt(j) == 'R') {
                reverse = !reverse;
            } else if(s.charAt(j) == 'D') {
                if(intList.isEmpty()) {
                    return "error\n";
                } else if(reverse){
                    intList.removeLast();
                } else {
                    intList.removeFirst();
                }
            }
        }

        sb.append("[");
        while (!intList.isEmpty()) {
            sb.append(reverse ? intList.removeLast() : intList.removeFirst());
            if (!intList.isEmpty())
                sb.append(",");
        }
        sb.append("]\n");

        return sb.toString();
    }

}
