import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean combi(int depth, int start, int[] arr, int[] result) throws IOException {

        if(depth == 7) {

            int sum = 0;

            for(int n : result) {
                sum += n;
            }

            if(sum == 100) {
                Arrays.sort(result);
                for(int n : result) {
                    bw.write(n + "");
                    bw.newLine();
                }
                return true;
            }

            return false;
        }

        for(int i = start; i < arr.length; i++) {
            result[depth] = arr[i];
            if(combi(depth + 1, i + 1, arr, result)) return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        int[] arr = new int[9];

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        combi(0, 0, arr, new int[7]);

        bw.flush();
        br.close();
        bw.close();
    }
}