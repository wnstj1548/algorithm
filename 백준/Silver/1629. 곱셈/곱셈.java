import java.io.*;
import java.util.*;

public class Main {

    public static long pow(long base, int exp, int mod) {

        if(exp == 0) return 1L;
        if(exp == 1) return base % mod;

        long half = pow(base, exp / 2, mod) % mod;
        half = (half * half) % mod;

        if(exp % 2 == 1) {
            return (base * half) % mod;
        } else {
            return half;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = pow(a, b, c);

        bw.write(result + "");

        bw.flush();
        br.close();
        bw.close();
    }
}