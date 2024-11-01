import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] s = st.nextToken().toCharArray();
        long n = Long.parseLong(st.nextToken());
        double sum = 0;

        for(int i = s.length - 1 ; i >= 0; i--) {
             sum += changeToNumber(s[s.length -1 - i]) * Math.pow(n, i);
        }

        bw.write((long)sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static long changeToNumber(char c) {
        return switch(c) {
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case 'A' -> 10;
            case 'B' -> 11;
            case 'C' -> 12;
            case 'D' -> 13;
            case 'E' -> 14;
            case 'F' -> 15;
            case 'G' -> 16;
            case 'H' -> 17;
            case 'I' -> 18;
            case 'J' -> 19;
            case 'K' -> 20;
            case 'L' -> 21;
            case 'M' -> 22;
            case 'N' -> 23;
            case 'O' -> 24;
            case 'P' -> 25;
            case 'Q' -> 26;
            case 'R' -> 27;
            case 'S' -> 28;
            case 'T' -> 29;
            case 'U' -> 30;
            case 'V' -> 31;
            case 'W' -> 32;
            case 'X' -> 33;
            case 'Y' -> 34;
            case 'Z' -> 35;
            default -> 0;
        };
    }
}