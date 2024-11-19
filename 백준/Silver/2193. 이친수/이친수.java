import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] zero = new long[n+1];
        long[] one = new long[n+1];

        if( n == 1) {
            bw.write("1\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        zero[2] = 1;
        one[1] = 1;

        for(int i = 3; i <= n; i++) {
            zero[i] = one[i-1] + zero[i-1];
            one[i] = zero[i-1];
        }

        bw.write((one[n] + zero[n]) + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}