import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] intArray = new int[n];
        int count = 0;
        int start = 0;
        int end = n-1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArray);

        int x = Integer.parseInt(br.readLine());

        while(start < end) {
            if(intArray[start] + intArray[end] == x) {
                count++;
                start++;
                end--;
            } else if (intArray[start] + intArray[end] < x) {
                start++;
            } else if (intArray[start] + intArray[end] > x) {
                end--;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
