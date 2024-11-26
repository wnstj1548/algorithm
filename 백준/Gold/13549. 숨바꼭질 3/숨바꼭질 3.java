import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[100001];
        Arrays.fill(arr, -1);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr[n] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()) {

            int temp = queue.poll();

            if(temp == k) {
                bw.write(arr[k] + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            if(2 * temp < 100001 && (arr[2*temp] == -1 || arr[2*temp] > arr[temp])) {
                arr[2*temp] = arr[temp];
                queue.add(2*temp);
            }

            if(temp + 1 < 100001 && (arr[temp+1] == -1 || arr[temp+1] > arr[temp] + 1)) {
                arr[temp+1] = arr[temp] + 1;
                queue.add(temp+1);
            }

            if(temp -1 >= 0 && (arr[temp-1] == -1 || arr[temp-1] > arr[temp] + 1)) {
                arr[temp-1] = arr[temp] + 1;
                queue.add(temp-1);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}