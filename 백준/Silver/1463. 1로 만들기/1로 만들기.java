import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visited;

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            if(temp == 1) {
                return arr[temp];
            }
            visited[temp] = true;

            if(temp/3 > 0 && temp/3 < n && temp % 3 == 0 && !visited[temp/3]) {
                queue.add(temp / 3);
                arr[temp/3] = arr[temp] + 1;
                visited[temp/3] = true;
            }

            if(temp/2 > 0 && temp/2 < n && temp % 2 == 0 && !visited[temp/2]) {
                queue.add(temp / 2);
                arr[temp/2] = arr[temp] + 1;
                visited[temp/2] = true;
            }

            if(temp-1 > 0 && temp-1 < n && !visited[temp-1]) {
                queue.add(temp - 1);
                arr[temp - 1] = arr[temp] + 1;
                visited[temp-1] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        int result = bfs();

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}