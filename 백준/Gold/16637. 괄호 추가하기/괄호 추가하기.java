import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String s;
    static int ret = Integer.MIN_VALUE;
    static List<Character> operList = new ArrayList<>();
    static List<Integer> numList = new ArrayList<>();

    static int oper(char op, int a, int b) {
        if(op == '+') return a + b;
        if(op == '-') return a - b;
        return a * b;
    }

    static void go(int here, int curNum) {
        if(here == numList.size() -1) {
            ret = Math.max(ret, curNum);
            return;
        }

        go(here + 1, oper(operList.get(here), curNum, numList.get(here + 1)));

        if(here + 2 <= numList.size() -1) {
            int temp = oper(operList.get(here + 1), numList.get(here + 1), numList.get(here + 2));
            go(here + 2, oper(operList.get(here), curNum, temp));
        }
    }

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        s = br.readLine();

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) numList.add(s.charAt(i) - '0');
            else operList.add(s.charAt(i));
        }

        go(0, numList.get(0));

        bw.write(ret + "");
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}