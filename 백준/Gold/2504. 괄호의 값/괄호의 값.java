import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int value = 1;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                value *= 2;
            } else if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                value *= 3;
            } else if (s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                } else if(s.charAt(i-1) == '(') {
                    sum += value;
                }
                stack.pop();
                value /=2;
            } else if (s.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                } else if (s.charAt(i-1) == '[') {
                    sum += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) {
            bw.write("0\n");
        } else {
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
