import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, len;
    static int[] lis, idxArr, numArr;
    static Stack<Integer> stack = new Stack<>();

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static long nextLong() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }

    public static int lowerBound(int target) {

        int left = 0;
        int right = len;

        while(left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();

        lis = new int[n];
        idxArr = new int[n];
        numArr = new int[n];

        Arrays.fill(lis, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            int num = nextInt();
            int pos = lowerBound(num);

            if(lis[pos] == Integer.MAX_VALUE) len++;

            lis[pos] = num;
            idxArr[i] = pos;
            numArr[i] = num;
        }

        bw.write(String.valueOf(len));
        bw.newLine();

        int target = len -1;

        for(int i = n -1; i >= 0; i--) {
            if (idxArr[i] == target) {
                stack.push(numArr[i]);
                target--;
            }
        }

        while(!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}