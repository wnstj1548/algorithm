import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[t+1];
        int[][] result = new int[w+1][t+1];

        for(int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= t; i++) {
            for(int j = 0; j <= w; j++) {
                if (arr[i] == 1 && j % 2 == 0) {
                    if (j != 0) {
                        result[j][i] += Math.max(result[j - 1][i - 1], result[j][i - 1]) + 1;
                    } else {
                        result[j][i] = result[j][i - 1] + 1;
                    }
                } else if (arr[i] == 2 && j % 2 == 1) {
                    result[j][i] = Math.max(result[j - 1][i - 1], result[j][i - 1]) + 1;
                } else {
                    result[j][i] = result[j][i - 1];
                }
            }
        }

        int max = 0;

        for(int i = 0; i <= w; i++) {
            for(int j = 1; j <=t; j++) {
                if(max < result[i][j]) {
                    max = result[i][j];
                }
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}