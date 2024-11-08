import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Character> frontStack = new Stack<>();
        Stack<Character> backStack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char[] cArray = br.readLine().toCharArray();

            for(int j = 0; j < cArray.length; j++) {
                if(cArray[j] == '>') {
                    if(!backStack.isEmpty()) {
                        frontStack.push(backStack.pop());
                    }
                } else if(cArray[j] == '<') {
                    if(!frontStack.isEmpty()) {
                        backStack.push(frontStack.pop());
                    }
                } else if(cArray[j] == '-') {
                    if(!frontStack.isEmpty()) {
                        frontStack.pop();
                    }
                } else {
                    frontStack.push(cArray[j]);
                }
            }

            StringBuilder sb = new StringBuilder();

            while(!backStack.isEmpty()) {
                frontStack.push(backStack.pop());
            }

            while(!frontStack.isEmpty()) {
                sb.append(frontStack.pop());
            }
            bw.write(sb.reverse().toString() + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
