import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Integer> stack = new Stack<>();
    static int max = 0;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] d = new int[n];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                d[i] = 1;
                d[stack.pop()] = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(d[i] == 1) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 0;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}