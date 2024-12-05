import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int l;
    static char[] arr;
    static StringBuilder sb;

    public static void dfs(int depth, char[] temp, boolean[] visited, int start) {

        if(depth == l) {

            int vowel = 0;
            int consonant = 0;

            for(int i = 0; i < l; i++) {
                if(temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
                sb.append(temp[i] + "");
            }
            sb.append("\n");

            if(!(vowel >= 1 && consonant >= 2)) {
                sb.setLength(sb.length()-l-1);
            }

            return;
        }

        for(int i = start; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                dfs(depth+1, temp, visited, i+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[c];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, new char[l], new boolean[c], 0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}