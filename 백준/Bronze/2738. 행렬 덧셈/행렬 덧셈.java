import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int[][] array1 = new int[n][m];
        int[][] array2 = new int[n][m];
        int[][] result = new int[n][m];

        for(int i = 0; i<n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                array1[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for(int i = 0; i<n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                array2[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                result[i][j] = array1[i][j] + array2[i][j];
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


