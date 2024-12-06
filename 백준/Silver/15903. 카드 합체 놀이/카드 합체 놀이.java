import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        Queue<Long> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        long sum = 0;

        for(long i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for(long i = 0; i < m; i++) {
            long x = queue.poll();
            long y = queue.poll();
            long temp = x + y;
            queue.add(temp);
            queue.add(temp);
        }

        while(!queue.isEmpty()) {
            sum += queue.poll();
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}