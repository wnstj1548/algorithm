import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] adj = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            adj[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1; i >= 0; i--) {

            while(!stack.isEmpty() && stack.peek() <= adj[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(adj[i]);
        }

        for(int i : result) {
            bw.write(i + " ");
        }

        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}