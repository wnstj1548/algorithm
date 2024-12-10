import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            stack.push(c);

            if(stack.size() >= 4) {

                if(stack.get(stack.size() - 1) == 'P' &&
                stack.get(stack.size() - 2) == 'A' &&
                stack.get(stack.size() - 3) == 'P' &&
                stack.get(stack.size() - 4) == 'P') {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push('P');
                }
            }
        }

        if(stack.size() == 1 && stack.peek() == 'P') {
            bw.write("PPAP\n");
        } else {
            bw.write("NP\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}