import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry o) {

            if(this.weight == o.weight) {
                return o.price - this.price;
            }

            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        long sum = 0L;

        Jewelry[] jewelries = new Jewelry[n];
        int[] bags = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(weight, price);
        }

        for(int i = 0; i < k; i++) {
            int weight = Integer.parseInt(br.readLine());
            bags[i] = weight;
        }

        Arrays.sort(jewelries);
        Arrays.sort(bags);

        int j = 0;
        for(int i = 0; i < k; i++) {
            while(j < n && bags[i] >= jewelries[j].weight) {
                pq.offer(jewelries[j].price);
                j++;
            }

            if(!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}