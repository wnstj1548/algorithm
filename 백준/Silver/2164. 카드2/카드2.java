import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i =1; i<n+1; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            queue.poll();

            if(queue.size() == 1) {
                break;
            }

            int temp = queue.poll();
            queue.add(temp);

        }

        bw.write(queue.poll() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
