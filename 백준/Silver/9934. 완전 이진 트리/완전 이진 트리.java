import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int k;
    static List<Integer>[] levelList = new List[11];
    static int[] arr = new int[1024];

    public static void go(int s, int e, int level) {
        if (s > e) return;

        if (s == e) {
            levelList[level].add(arr[s]);
            return;
        }

        int mid = (s+e) / 2;
        levelList[level].add(arr[mid]);
        go(s, mid -1, level + 1);
        go(mid + 1, e, level + 1);
    }

    public static void main(String[] args) throws Exception {

        k = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < 11; i++) {
            levelList[i] = new ArrayList<>();
        }

        int end = (int) Math.pow(2, k) -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < end; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        go(0, end -1, 1);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= k; i++) {
            for(int v : levelList[i]) sb.append(v).append(' ');
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}