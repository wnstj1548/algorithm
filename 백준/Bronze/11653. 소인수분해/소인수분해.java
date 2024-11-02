import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = makePrime(n);
        List<Integer> intList = new ArrayList<>();

        primeFactor(n, isPrime, intList);

        for(int i : intList) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean[] makePrime(int n) {

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[1] = prime[0] = false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]) {
                for(int j = i*i; j<=n; j+=i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    public static void primeFactor(int n, boolean[] isPrime, List<Integer> intList) {
        for (int i = 2; i<= n; i++) {
            if (isPrime[i] && (n%i == 0)) {
                intList.add(i);
                primeFactor(n/i, isPrime, intList);
                return;
            }
        }
    }
}
