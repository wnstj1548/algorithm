import java.io.*;
import java.util.*;

class Main {

    static int[] arr;
    static int[] before;

    static void bfs(int start, int end) {

        arr = new int[100001];
        before = new int[100001];

        Arrays.fill(arr, -1);
        arr[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == end) {
                return;
            }

            if(now + 1 <= 100000 && arr[now+1] == -1) {
                arr[now+1] = arr[now] + 1;
                before[now+1] = now;
                queue.add(now+1);
            }

            if(0 <= now - 1 && arr[now-1] == -1) {
                arr[now-1] = arr[now] + 1;
                before[now-1] = now;
                queue.add(now-1);
            }

            if(now * 2 <= 100000 && arr[now*2] == -1) {
                arr[now*2] = arr[now] + 1;
                before[now*2] = now;
                queue.add(now*2);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if(start == end) {
            bw.write("0\n" + start + "\n");
            bw.flush();
            bw.close();
            br.close();
        } else {
            bfs(start, end);

            bw.write(arr[end] + "\n");

            Stack<Integer> stack = new Stack<>();
            stack.push(end);

            int temp = end;

            while(temp != start) {
                stack.push(before[temp]);
                temp = before[temp];
            }

            while(!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }
}