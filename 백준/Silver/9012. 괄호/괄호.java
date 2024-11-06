import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {

            int count = 0;

            char[] array = br.readLine().toCharArray();

            for(int j =0; j<array.length; j++) {
                if(array[j] == '(') {
                    count++;
                } else if(array[j] == ')') {
                    count--;
                    if(count < 0) {
                        bw.write("NO\n");
                        break;
                    }
                }

                if(j == array.length - 1 && count != 0) {
                    bw.write("NO\n");
                } else if(j == array.length - 1 && count == 0) {
                    bw.write("YES\n");
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
