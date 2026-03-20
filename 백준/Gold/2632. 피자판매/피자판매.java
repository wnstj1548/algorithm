import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int size, n, m;
    static int[] a;
    static int[] b;
    static Map<Integer, Integer> aMap = new HashMap<>();
    static Map<Integer, Integer> bMap = new HashMap<>();

    static int[] prefixSum(int[] arr, int size) {
        int[] prefix = new int[2 * size + 1];

        for(int i = 1; i <= size; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for(int i = size + 1; i <= 2 * size; i++) {
            prefix[i] = prefix[i-1] + arr[i-size];
        }

        return prefix;
    }

    static void countSubSums(int size, int[] prefix, Map<Integer, Integer> map) {
        for(int length = 1; length <= size; length++) {
            for(int end = length; end <= length + size - 1; end++) {
                int sum = prefix[end] - prefix[end - length];
                map.put(sum, map.getOrDefault(sum, 0) + 1);

                if(length == size) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 1];
        b = new int[m + 1];

        for(int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(br.readLine());
            a[i] = temp;
        }

        for(int i = 1; i <= m; i++) {
            int temp = Integer.parseInt(br.readLine());
            b[i] = temp;
        }

        int[] prefixA = prefixSum(a, n);
        int[] prefixB = prefixSum(b, m);

        countSubSums(n, prefixA, aMap);
        countSubSums(m, prefixB, bMap);

        long answer = 0;

        answer += aMap.getOrDefault(size, 0);
        answer += bMap.getOrDefault(size, 0);

        for(int i = 1; i < size; i++) {
            int remain = size - i;
            int aCount = aMap.getOrDefault(i, 0);
            int bCount = bMap.getOrDefault(remain, 0);

            answer += (long) aCount * bCount;
        }

        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}