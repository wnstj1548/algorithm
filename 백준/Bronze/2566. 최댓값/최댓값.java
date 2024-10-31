import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int x = 0;
        int y = 0;
        int[][] array = new int[9][9];

        for(int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<9; j++) {
                if(st.hasMoreTokens()) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                    if(array[i][j] >= max) {
                        max = array[i][j];
                        x = i+1;
                        y = j+1;
                    }
                }
            }
        }

        bw.write(max + "\n" + x + " " + y + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}


