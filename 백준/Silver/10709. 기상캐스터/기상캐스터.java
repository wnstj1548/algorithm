import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        arr = new int[h][w];

        for(int i = 0; i < h; i++) {
            int lastCloud = -1;
            String s = br.readLine();
            for(int j = 0; j < w; j++) {
                if(s.charAt(j) == 'c') {
                    lastCloud = j;
                }

                if(lastCloud == -1) {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = j - lastCloud;
                }
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}