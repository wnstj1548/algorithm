import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] intArray = new int[n];

        int[] intArray2 = new int[n];

        for(int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< n; i++) {

            while(!stack.isEmpty() && intArray[stack.peek()] < intArray[i]) {
                stack.pop();
            }

            while(!stack.isEmpty() && intArray[stack.peek()] > intArray[i]) {
                intArray2[i] = stack.peek() + 1;
                stack.push(i);
            }

            if(stack.isEmpty()) {
                intArray2[i] = 0;
                stack.push(i);
            }
        }

        for(int i : intArray2) {
            bw.write(i + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
