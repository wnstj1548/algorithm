import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int score = Integer.parseInt(s);

        if(90 <= score && score <= 100 ) {
            System.out.println("A");
        } else if(80 <= score && score <= 89 ) {
            System.out.println("B");
        } else if(70 <= score && score <= 79 ) {
            System.out.println("C");
        } else if(60 <= score && score <= 69 ) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}