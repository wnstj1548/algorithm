import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[30];

        for(int i =0; i < 28; i++) {

            int a = Integer.parseInt(br.readLine());
            arr[a-1] = 1;
        }

        for(int i = 0; i<30; i++) {

            if(arr[i] == 0) {
                bw.write((i + 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}