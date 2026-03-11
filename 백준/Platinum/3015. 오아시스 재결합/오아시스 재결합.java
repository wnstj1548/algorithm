import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    static class Person {
        long height;
        long count;

        public Person(long height, long count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        long sum = 0;

        Stack<Person> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            long temp = Long.parseLong(br.readLine());
            long cnt = 1;

            while(!stack.isEmpty() && stack.peek().height <= temp) {
                sum += stack.peek().count;

                if(stack.peek().height == temp) {
                    cnt = stack.peek().count + 1;
                } else {
                    cnt = 1;
                }

                stack.pop();
            }

            if(!stack.isEmpty()) {
                sum++;
            }

            stack.push(new Person(temp, cnt));
        }

        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}