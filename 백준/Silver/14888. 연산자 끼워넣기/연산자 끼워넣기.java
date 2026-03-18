import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] num;
    static char[] oper;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static int calc(char oper, int num1, int num2) {
        return switch(oper) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new IllegalStateException("Unexpected value: " + oper);
        };
    }

    public static void perm(int depth, List<Character> temp) {

        if(depth == n - 1) {
            int prev = num[0];

            for(int i = 0; i < n-1; i++) {
                prev = calc(temp.get(i), prev, num[i+1]);
            }

            min = Math.min(prev, min);
            max = Math.max(prev, max);
        }

        for(int i = 0; i < n-1; i++) {
            if(visited[i]) continue;
            temp.add(oper[i]);
            visited[i] = true;
            perm(depth+1, temp);
            temp.remove(temp.size() -1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        oper = new char[n-1];
        visited = new boolean[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plusCount = Integer.parseInt(st.nextToken());

        int idx = 0;

        while(plusCount > 0) {
            plusCount--;
            oper[idx] = '+';
            idx++;
        }

        int minusCount = Integer.parseInt(st.nextToken());

        while(minusCount > 0) {
            minusCount--;
            oper[idx] = '-';
            idx++;
        }

        int multiCount = Integer.parseInt(st.nextToken());

        while(multiCount > 0) {
            multiCount--;
            oper[idx] = '*';
            idx++;
        }

        int divideCount = Integer.parseInt(st.nextToken());

        while(divideCount > 0) {
            divideCount--;
            oper[idx] = '/';
            idx++;
        }

        perm(0, new ArrayList<>());

        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}