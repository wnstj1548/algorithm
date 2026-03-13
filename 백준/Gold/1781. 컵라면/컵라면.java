import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static class Problem implements Comparable<Problem> {
        int deadline;
        int ramyeon;

        public Problem(int deadline, int ramyeon) {
            this.deadline = deadline;
            this.ramyeon = ramyeon;
        }

        @Override
        public int compareTo(Problem o) {

            if(this.deadline == o.deadline) {
                return o.ramyeon - this.ramyeon;
            }

            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Problem[] problems = new Problem[n + 1];
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramyeon = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(deadline, ramyeon);
        }

        Arrays.sort(problems, 1, n+1);

        for(int i = 1; i <= n; i++) {
            pq.offer(problems[i].ramyeon);

            while(pq.size() > problems[i].deadline) {
                pq.poll();
            }
        }

        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}