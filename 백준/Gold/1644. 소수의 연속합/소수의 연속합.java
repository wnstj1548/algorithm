import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<Integer> arr = new ArrayList<>();
    static boolean[] prime;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        prime = new boolean[n+1];
        int cnt = 0;
        int sum = 0;
        Arrays.fill(prime, true);

        prime();

        int left = 0;
        int right = 0;

        while(true) {
            if(sum >= n) {
                if(sum == n) cnt++;
                sum -= arr.get(left++);
            } else {
                if(right == arr.size()) break;
                sum += arr.get(right++);
            }
        }

        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    public static void prime() {

        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for(int i = 0; i <= n; i++) {
            if(prime[i]) {
                arr.add(i);
            }
        }
    }
}