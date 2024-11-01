import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i< n; i++) {
            
            int money = Integer.parseInt(br.readLine());
            
            bw.write(money/25 + " ");
            money = money % 25;
            bw.write(money/10 + " ");
            money = money % 10;
            bw.write(money/5 + " ");
            money = money % 5;
            bw.write(money + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}