import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] arr = new int[26];

        for(char c : s.toCharArray()) {
            arr[c - 'A']++;
        }

        StringBuilder left = new StringBuilder();
        int oddIndex = -1;
        boolean isPossible = true;

        for(int i = 0; i < 26; i++) {

            if(arr[i] % 2 == 1) {
                if(oddIndex == -1) {
                    oddIndex = i;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if(arr[i] > 1) {
                for(int ii = 0; ii < arr[i] / 2; ii++) {
                    left.append((char) (i + 'A'));
                }
            }
        }

        String mid = "";

        if(oddIndex != -1) {
            mid = String.valueOf((char) (oddIndex + 'A'));
        }

        if(!isPossible) {
            bw.write("I'm Sorry Hansoo");
            bw.newLine();
        } else {
            bw.write(left.toString() + mid + left.reverse().toString());
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}