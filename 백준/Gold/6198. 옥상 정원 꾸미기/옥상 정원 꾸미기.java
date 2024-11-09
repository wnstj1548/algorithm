import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] array = new int[n];
        long sum = 0;

        for(int i = 0; i<n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<n; i++) {

            while(!stack.isEmpty() && array[stack.peek()] <= array[i]) {
                stack.pop();
            }

            sum += stack.size();
            
            stack.push(i);
        }

        bw.write(sum + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
