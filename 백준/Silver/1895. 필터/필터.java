import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] filtered;

    public static void filter(int x, int y) {

        int[] temp = new int[9];

        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                temp[(i-x)*3 + (j-y)] = arr[i][j];
            }
        }

        Arrays.sort(temp);

        filtered[x][y] = temp[4];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int count = 0;

        if (r < 3 || c < 3) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        arr = new int[r][c];
        filtered = new int[r-2][c-2];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < r-2; i++) {
            for(int j = 0; j < c-2; j++) {
                filter(i, j);
            }
        }

        for(int i = 0; i < r-2; i++) {
            for(int j = 0; j < c-2; j++) {
                if(t <= filtered[i][j]) {
                    count++;
                }
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}