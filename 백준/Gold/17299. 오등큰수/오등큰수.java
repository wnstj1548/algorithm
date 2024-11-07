import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> intMap = new HashMap<>();
        int[] intArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
            intMap.put(intArray[i], intMap.getOrDefault(intArray[i], 0) + 1);
        }

        for(int i = 0; i<n; i++) {


            while(!stack.isEmpty() && intMap.get(intArray[stack.peek()]) < intMap.get(intArray[i])) {
                intArray[stack.pop()] = intArray[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            intArray[stack.pop()] = -1;
        }

        for(int i = 0; i<intArray.length; i++) {
            bw.write(intArray[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
