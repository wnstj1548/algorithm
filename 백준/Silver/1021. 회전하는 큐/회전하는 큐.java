import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int now = 0;
        int count = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i<= n; i++) {
            deque.add(i);
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] array = new int[m];

        for(int i = 0; i<m; i++) {
            array[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i = 0; i<m; i++) {
            int index = deque.indexOf(array[i]);
            int min = Math.abs(index - now);
            if(min > deque.size()/2) {
                min = deque.size() - min;
            }
            count += min;
            now = index;
            deque.remove(index);
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
