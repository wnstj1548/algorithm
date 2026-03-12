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

            if(s.money == this.money) {
                return this.day - s.day;
            }

            return s.money - this.money;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        Speech[] speeches = new Speech[n];
        int maxDay = 0;

        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            speeches[i] = new Speech(day, money);
            maxDay = Math.max(maxDay, day);
        }

        Arrays.sort(speeches);
        boolean[] visited = new boolean[maxDay + 1];
        int sum = 0;

        for(Speech s : speeches) {
            for(int d = s.day; d >= 1; d--) {
                if(!visited[d]) {
                    visited[d] = true;
                    sum += s.money;
                    break;
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}