import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        Stack<String> stack = new Stack<>();

        while(!(s = br.readLine()).equals(".")) {

            for(int i = 0; i<s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i) + "");
                } else if(s.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        bw.write("no\n");
                        stack.clear();
                        break;
                    }
                } else if(s.charAt(i) == ']') {
                    if(!stack.isEmpty() && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        bw.write("no\n");
                        stack.clear();
                        break;
                    }
                }

                if(s.length()-1 == i && !stack.isEmpty()) {
                    bw.write("no\n");
                    stack.clear();
                } else if (s.length() -1 == i && stack.isEmpty()) {
                    bw.write("yes\n");
                    stack.clear();
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
