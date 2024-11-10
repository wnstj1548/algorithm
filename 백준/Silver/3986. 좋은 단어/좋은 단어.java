import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        for(int i = 0; i<n; i++) {
            String s = br.readLine();

            for(int j=0; j<s.length(); j++) {
                if(!stack.isEmpty() && stack.peek() == s.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }

            if(stack.isEmpty()) {
                sum++;
            }

            stack.clear();
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
