import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());

        if(x + y + z == 180) {
            if(x == y && x == z) {
                bw.write("Equilateral\n");
            } else if(x == y || y == z || z == x) {
                bw.write("Isosceles\n");
            } else {
                bw.write("Scalene\n");
            }
        } else {
            bw.write("Error\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}