import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();

        List<Double> doubleList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            doubleList.add(Double.parseDouble(br.readLine()));
        }

        Stack<Double> stack = new Stack<>();

        for(int i =0; i<charArray.length; i++) {
            if(charArray[i] == '*') {
                double b = stack.pop();
                double a = stack.pop();

                stack.push(a * b);
            } else if(charArray[i] == '+') {
                double b = stack.pop();
                double a = stack.pop();

                stack.push(a + b);
            } else if(charArray[i] == '-') {
                double b = stack.pop();
                double a = stack.pop();

                stack.push(a - b);
            } else if(charArray[i] == '/') {
                double b = stack.pop();
                double a = stack.pop();

                stack.push(a / b);
            } else {
                stack.push(toDouble(charArray[i], doubleList));
            }
        }

        System.out.printf("%.2f", stack.pop());

        bw.flush();
        br.close();
        bw.close();
    }

    public static Double toDouble(char c, List<Double> doubleList) {

        int a = c - 'A';

        return doubleList.get(a);
    }
}
