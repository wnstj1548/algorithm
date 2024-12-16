import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] bottom = new int[h+1];
        int[] top = new int[h+1];

        for(int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            if(i % 2 == 0) {
                bottom[height]++;
            } else {
                top[height]++;
            }
        }

        for (int i = h - 1; i >= 1; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 1; i <= h; i++) {

            int c = 0;

            c += bottom[i];
            c += top[h-i + 1];

            if(c < min) {
                min = c;
                count = 1;
            } else if(c == min) {
                count++;
            }
        }

        bw.write(min + " " + count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}