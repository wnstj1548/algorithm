import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> intList = new ArrayList<>();

        for(int i = 1; i<=a; i++) {
            if(a%i == 0) {
                intList.add(i);
            }
        }

        int result = intList.size() >= b ? intList.get(b-1) : 0 ;

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}