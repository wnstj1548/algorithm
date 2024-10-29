import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꼬마정민 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s, " ");

        long sum = 0L;

        while(st.hasMoreTokens()) {
            sum += Long.parseLong(st.nextToken());
        }

        System.out.print(sum);
    }
}