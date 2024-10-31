import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cookingTime = Integer.parseInt(br.readLine());

        int cookingHour = cookingTime / 60 + h;
        int cookingMinute = cookingTime % 60 + m;

        if(cookingMinute >= 60) {
            cookingMinute -= 60;
            cookingHour += 1;
        }

        if(cookingHour >= 24) {
            cookingHour -= 24;
        }

        System.out.println(cookingHour + " " +cookingMinute);

    }
}