import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Flower> flowers = new ArrayList<>();
        int count = 0;

        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;

            flowers.add(new Flower(start, end));
        }

        flowers.sort((o1, o2) -> {
            if(o1.start == o2.start) return o2.end - o1.end;
            return o1.start - o2.start;
        });

        int start = 301;
        int max = 0;

        while(start < 1201) {
            boolean ch = false;
            for(int i = 0; i < n; i++) {

                if(flowers.get(i).start > start) break;

                if(flowers.get(i).start <= start && max < flowers.get(i).end) {
                    max = flowers.get(i).end;
                    ch = true;
                }
            }

            if(ch) {
                start = max;
                count++;
            } else break;
        }

        if(max < 1201) {
            bw.write("0\n");
        } else {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

class Flower {

    int start;
    int end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}