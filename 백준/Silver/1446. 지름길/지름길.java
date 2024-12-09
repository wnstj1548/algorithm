import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        class Shortcut {
            int start;
            int end;
            int weight;

            Shortcut(int start, int end, int weight) {
                this.start = start;
                this.end = end;
                this.weight = weight;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();
        int[] result = new int[10001];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(end <= length && (end - start) > weight) {
                shortcuts.add(new Shortcut(start, end, weight));
            }
        }

        Collections.sort(shortcuts, (o1, o2) -> {

            if(o1.start == o2.start) {
                return o1.end - o2.end;
            }

            return o1.start - o2.start;
        });

        Arrays.fill(result, Integer.MAX_VALUE);

        result[0] = 0;

        for(int i = 0; i <= length; i++) {

            if (i > 0) {
                result[i] = Math.min(result[i-1] + 1, result[i]);
            }

            for(Shortcut shortcut : shortcuts) {
                if(shortcut.start == i) {
                    result[shortcut.end] = Math.min(result[shortcut.end], result[shortcut.start] + shortcut.weight);
                }
            }
        }

        bw.write(result[length] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}