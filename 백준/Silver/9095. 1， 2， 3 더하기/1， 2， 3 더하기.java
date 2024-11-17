import java.io.*;

public class Main {

    public static int recur(int a) {

        if(a == 1) return 1;
        if(a == 2) return 2;
        if(a == 3) return 4;

        return recur(a-1) + recur(a-2) + recur(a-3);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            bw.write(recur(a) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}