import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static class Cow implements Comparable<Cow>{
        int arrive;
        int time;

        public Cow(int arrive, int time) {
            this.arrive = arrive;
            this.time = time;
        }

        @Override
        public int compareTo(Cow c) {
            return this.arrive - c.arrive;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[n];
        int now = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int arrive = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(arrive, time);
        }

        Arrays.sort(cows);

        for(Cow cow : cows) {
            if(now <= cow.arrive) {
                now = cow.arrive + cow.time;
            } else {
                now += cow.time;
            }
        }

        bw.write(String.valueOf(now));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}