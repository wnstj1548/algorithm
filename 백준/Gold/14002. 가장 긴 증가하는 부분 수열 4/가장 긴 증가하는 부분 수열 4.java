import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] length = new int[n];
        int[] before = new int[n];
        Arrays.fill(before, -1);
        Arrays.fill(length, 1);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        length[0] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && length[j] + 1 > length[i]) {
                    before[i] = j;
                    length[i] = length[j] + 1;
                }
            }
        }

        int maxLength = 0;
        int maxIndex = 0;

        for(int i = 0; i < n; i++) {
            if(length[i] > maxLength) {
                maxLength = length[i];
                maxIndex = i;
            }
        }

        bw.write(maxLength + "\n");

        while(before[maxIndex] != -1) {
            stack.push(arr[maxIndex]);
            maxIndex = before[maxIndex];
        }

        bw.write(arr[maxIndex] + " ");

        while(!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}