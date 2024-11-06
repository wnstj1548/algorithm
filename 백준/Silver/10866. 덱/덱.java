import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if(s.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if(s.equals("front")) {
                if(!deque.isEmpty()) {
                    bw.write(deque.getFirst() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(s.equals("back")) {
                if(!deque.isEmpty()) {
                    bw.write(deque.getLast() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(s.equals("size")) {
                bw.write(deque.size() + "\n");
            } else if(s.equals("empty")) {
                if(deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(s.equals("pop_front")) {
                if(!deque.isEmpty()) {
                    bw.write(deque.removeFirst() + "\n");
                } else {
                    bw.write("-1\n");
                }
            } else if(s.equals("pop_back")) {
                if(!deque.isEmpty()) {
                    bw.write(deque.removeLast() + "\n");
                } else {
                    bw.write("-1\n");
                }
            }

        }


        bw.flush();
        br.close();
        bw.close();
    }
}
