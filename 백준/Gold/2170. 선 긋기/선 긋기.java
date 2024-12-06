import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] line = new long[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            line[i][0] = Long.parseLong(st.nextToken());
            line[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Math.toIntExact(o1[1] - o2[1]);
            }

            return Math.toIntExact(o1[0] - o2[0]);
        });

        long start = line[0][0];
        long end = line[0][1];
        long sum = 0;

        for(int i = 1; i < n; i++) {
            if(end < line[i][0]){
                sum += end - start;
                start = line[i][0];
                end = line[i][1];
            } else if(start <= line[i][0] && end < line[i][1]) {
                end = line[i][1];
            }
        }

        sum += end - start;

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}