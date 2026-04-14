import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] prime = new boolean[19];

    static void initPrime() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i * i < 19; i++) {
            for(int j = i * i; j < 19; j += i) {
                prime[j] = false;
            }
        }
    }

    static int combi(int n, int r) {
        if(r > n) r = n - r;

        int res = 1;

        for(int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {

        initPrime();

        double a = 0.0d;
        double b = 0.0d;

        int aPercent = nextInt();
        int bPercent = nextInt();

        for(int i = 2; i < 19; i++) {
            if(prime[i]) {
                a += combi(18, i) * Math.pow(((double) aPercent / 100), i) * Math.pow((1 - ((double) aPercent / 100)), 18 - i);
                b += combi(18, i) * Math.pow(((double) bPercent / 100), i) * Math.pow((1 - ((double) bPercent / 100)), 18 - i);
            }
        }

        double res = a + b - (a * b);

        bw.write(String.valueOf(res));
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }

    public static int nextInt() throws IOException {
        while(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    /*
    A 소수인 확률 + B 소수인 확률 - (A, B 모두 소수인 확률)
     */
}