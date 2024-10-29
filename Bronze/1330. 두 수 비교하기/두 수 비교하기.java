import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int[] n = new int[2];

        for(int i = 0; i < 2; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        if(n[0] == n[1]) {
            System.out.println("==");
        } else if (n[0] > n[1]) {
            System.out.println(">");
        } else {
            System.out.println("<");
        }
    }
}