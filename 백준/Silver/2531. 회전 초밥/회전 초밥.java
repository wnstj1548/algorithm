import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] visited = new int[d+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        int max = 0;

        for(int i = 1; i <= k; i++) {

            if(visited[arr[i]] == 0) {
                visited[arr[i]] += 1;
                total++;
            } else {
                visited[arr[i]] += 1;
            }
        }

        if(visited[c] == 0) {
            total++;
        }

        max = total;

        for(int i = 1; i <= n; i++) {

            if(visited[c] == 0) {
                total--;
            }

            visited[arr[i]] -= 1;

            if(visited[arr[i]] == 0) {
                total--;
            }

            if(i+k > n) {
                if(visited[arr[i+k-n]] == 0) {
                    total++;
                }

                visited[arr[i+k-n]] += 1;
            } else {
                if(visited[arr[i+k]] == 0) {
                    total++;
                }

                visited[arr[i+k]] += 1;
            }

            if(visited[c] == 0) {
                total++;
            }

            if(max < total) {
                max = total;
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}