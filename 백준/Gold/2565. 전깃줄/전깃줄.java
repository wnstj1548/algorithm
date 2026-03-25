import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static int n, len;
    static Wire[] wires;
    static int[] lis;
    static int[] idxArr;
    static int[] numArr;

    public static class Wire implements Comparable<Wire> {
        int start;
        int end;

        public Wire(int start, int end) {
            this.end = end;
            this.start = start;
        }

        @Override
        public int compareTo(Wire o) {
            return this.start - o.start;
        }
    }

    public static int lowerBound(int target) {

        int left = 0;
        int right = len;

        while(left < right) {
            int mid = (left + right) / 2;

            if(lis[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception {

        n = nextInt();
        wires = new Wire[n];
        lis = new int[n];
        idxArr = new int[n];
        numArr = new int[n];

        for(int i = 0; i < n; i++) {
            int start = nextInt();
            int end = nextInt();
            wires[i] = new Wire(start, end);
        }

        Arrays.fill(lis, Integer.MAX_VALUE);
        Arrays.sort(wires);

        for(int i = 0; i < n; i++) {
            Wire wire = wires[i];
            int pos = lowerBound(wire.end);

            if(lis[pos] == Integer.MAX_VALUE) len++;

            lis[pos] = wire.end;
            idxArr[i] = pos;
            numArr[i] = wire.end;
        }

        bw.write(String.valueOf(n - len));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

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
}