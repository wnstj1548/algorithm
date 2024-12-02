import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[][] result;
    static int n,m;

    static boolean isSame() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != result[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void reverse(int x, int y) {
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
               arr[i][j] = arr[i][j] == 1 ?  0 : 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        result = new int[n][m];
        int count = 0;

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                result[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }

        if(n < 3 && m < 3 && isSame()) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        for(int i = 0; i < n-2; i++) {
            for(int j = 0; j < m-2; j++) {
                if(arr[i][j] != result[i][j]) {
                    reverse(i, j);
                    count++;
                }
            }
        }

        if(isSame()) {
            bw.write(count + "\n");
        } else {
            bw.write("-1\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
