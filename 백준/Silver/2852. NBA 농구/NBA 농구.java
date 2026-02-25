import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        //score
        int left = 0;
        int right = 0;

        int lastTime = 0;

        int leftTime = 0;
        int rightTime = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");

            int minute = Integer.parseInt(time[0]);
            int second = Integer.parseInt(time[1]);

            int now = minute * 60 + second;

            if(left > right) {
                leftTime += now - lastTime;
            }

            if(right > left) {
                rightTime += now - lastTime;
            }

            if(team == 1) {
                left += 1;
            } else {
                right += 1;
            }

            lastTime = now;
        }

        if(left > right) {
            leftTime += (48 * 60) - lastTime;
        }

        if(right > left) {
            rightTime += (48 * 60) - lastTime;
        }

        int leftMinute = leftTime / 60;
        int leftSecond = leftTime % 60;
        int rightMinute = rightTime / 60;
        int rightSecond = rightTime % 60;

        bw.write((leftMinute < 10 ? "0" + leftMinute : leftMinute) + ":" + (leftSecond < 10 ? "0" + leftSecond : leftSecond));
        bw.newLine();
        bw.write((rightMinute < 10 ? "0" + rightMinute : rightMinute) + ":" + (rightSecond < 10 ? "0" + rightSecond : rightSecond));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}