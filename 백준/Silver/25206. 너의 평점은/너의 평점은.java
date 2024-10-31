import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double creditSum = 0.0;
        double gradeSum = 0.0;

        for(int i =0; i<20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(!grade.equals("P")) {
                gradeSum += credit * parseGrade(grade);
                creditSum += credit;
            }
        }

        bw.write(gradeSum/creditSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static double parseGrade(String grade) {
        return switch(grade) {
            case "A+" -> 4.5;
            case "A0" -> 4.0;
            case "B+" -> 3.5;
            case "B0" -> 3.0;
            case "C+" -> 2.5;
            case "C0" -> 2.0;
            case "D+" -> 1.5;
            case "D0" -> 1.0;
            default -> 0.0;
        };
    }
}


