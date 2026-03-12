import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static class Speech implements Comparable<Speech> {
        int day;
        int money;

        public Speech(int day, int money) {
            this.day = day;
            this.money = money;
        }

        @Override
        public int compareTo(Speech s) {
            return this.day - s.day;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        Speech[] speeches = new Speech[n];

        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            speeches[i] = new Speech(day, money);
        }

        Arrays.sort(speeches);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.add(speeches[i].money);

            if(pq.size() > speeches[i].day) {
                pq.poll();
            }
        }

        int sum = 0;
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