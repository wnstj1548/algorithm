import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int sum = 0;


        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(String.valueOf(arr[i]));
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}