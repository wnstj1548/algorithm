import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];
        char[] input = br.readLine().toCharArray();
        char[] s = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for(int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        for(int i=0; i<input.length; i++) {

            for(int j =0; j<26; j++) {
                if(input[i] == s[j] && arr[j] == -1) {
                    arr[j] = i;
                }
            }
        }

        for(int i : arr) {
            bw.write(i + " ");
        }

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

}