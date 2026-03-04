import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int k;
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static boolean[] visited;
    static String max = null;
    static String min = null;

    static Comparator<String> comparator = (a, b) -> {
        int lenCmp = Integer.compare(a.length(), b.length());
        if (lenCmp != 0) return lenCmp;
        return a.compareTo(b);
    };

    public static void dfs(int depth, int previous) {

        if(depth == k+1) {
            String s = sb.toString();
            if(min == null || comparator.compare(s, min) < 0) min = s;
            if(max == null || comparator.compare(s, max) > 0) max = s;
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            if(!oper(arr[depth-1], previous, i)) {
                continue;
            } else {
                sb.append(String.valueOf(i));
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
                sb.deleteCharAt(sb.length() -1);
            }
        }
    }

    public static boolean oper(char c, int a, int b) {

        if(c == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }

    public static void main(String[] args) throws Exception {

        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        for(int i = 0; i < 10; i++) {
            sb.append(i);
            visited[i] = true;
            dfs(1, i);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }

        bw.write(max);
        bw.newLine();
        bw.write(min);

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}