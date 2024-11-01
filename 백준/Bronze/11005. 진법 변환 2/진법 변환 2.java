import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long n2 = n;
        int length = 1;
        StringBuilder sb = new StringBuilder();

        while(n2/b != 0) {
            length++;
            n2 = n2/b;
        }

        for(int i=length-1; i>0; i--) {
            sb.append(changeToB((int)(n / Math.pow(b, i))));
            n = (long) (n % Math.pow(b,i));
        }

        sb.append(changeToB((int)n));

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static String changeToB(int i) {
        return switch(i) {
            case 0 -> "0";
            case 1 -> "1";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            case 16 -> "G";
            case 17 -> "H";
            case 18 -> "I";
            case 19 -> "J";
            case 20 -> "K";
            case 21 -> "L";
            case 22 -> "M";
            case 23 -> "N";
            case 24 -> "O";
            case 25 -> "P";
            case 26 -> "Q";
            case 27 -> "R";
            case 28 -> "S";
            case 29 -> "T";
            case 30 -> "U";
            case 31 -> "V";
            case 32 -> "W";
            case 33 -> "X";
            case 34 -> "Y";
            case 35 -> "Z";
            default -> "";
        };
    }
}