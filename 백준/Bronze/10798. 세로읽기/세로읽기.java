import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] array = new char[5][15];

        for(int i =0; i<5; i++) {
            char[] chars = br.readLine().toCharArray();

            for(int j = 0; j<chars.length; j++) {
                if(chars[j] != ' ') {
                    array[i][j] = chars[j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<15; i++) {
            for(int j=0; j<5; j++) {
                if(array[j][i] != ' ' && array[j][i] != '\0') {
                    sb.append(array[j][i]);
                }
            }
        }

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}