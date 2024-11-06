import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int count = 1;
        int num = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++) {

            int a = Integer.parseInt(br.readLine());

            while(count <= a) {
                stack.push(count);
                count++;
                num++;
                sb.append("+\n");
            }

            if(count > a) {
                num = stack.pop();

                if(a == num) {
                    sb.append("-\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        String s = sb.toString();

        if(s.contains("NO")) {
            bw.write("NO\n");
        } else {
            bw.write(s);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
