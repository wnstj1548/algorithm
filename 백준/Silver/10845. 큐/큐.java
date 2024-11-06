import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if(s.equals("pop")) {
                if(!queue.isEmpty()) {
                    bw.write(queue.poll() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(s.equals("front")) {
                if(!queue.isEmpty()) {
                    bw.write(queue.peek() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(s.equals("back")) {
                if(!queue.isEmpty()) {
                    bw.write(((LinkedList) queue).get(queue.size() -1) + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(s.equals("empty")) {
                if(queue.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(s.equals("size")) {
                bw.write(queue.size() + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
