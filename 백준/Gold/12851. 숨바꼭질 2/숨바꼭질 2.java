import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] count;

    public static void bfs(int start) {

        arr[start] = 0;
        count[start] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now -1 >= 0 && arr[now -1] == -1) {
                arr[now-1] = arr[now] + 1;
                queue.add(now-1);
                count[now-1]++;
            } else if (now -1 >= 0 && arr[now -1] == arr[now] + 1) {
                count[now-1]++;
                queue.add(now-1);
            }

            if(now + 1 <= 100000 && arr[now+1] == -1) {
                arr[now+1] = arr[now] + 1;
                queue.add(now+1);
                count[now+1]++;
            } else if (now + 1 <= 100000 && arr[now+1] == arr[now] + 1) {
                count[now+1]++;
                queue.add(now+1);
            }

            if(now * 2 <= 100000 && arr[now*2] == -1) {
                arr[now*2] = arr[now] + 1;
                queue.add(now*2);
                count[now*2]++;
            } else if(now * 2 <= 100000 && arr[now*2] == arr[now] + 1) {
                count[now*2]++;
                queue.add(now*2);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        count = new int[100001];
        Arrays.fill(arr, -1);

        bfs(start);

        bw.write(arr[end] + "\n" + count[end] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}