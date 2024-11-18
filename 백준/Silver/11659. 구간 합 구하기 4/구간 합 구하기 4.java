import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n+1];
        array[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken()) + array[i-1];
        }

        for(int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(array[b] - array[a-1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}