import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Car> carList = new ArrayList<>();

        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Car car = new Car(start, end);
            carList.add(car);

            if(min > start) min = start;
            if(max < end) max = end;
        }

        Collections.sort(carList);

        for(int i = min; i < max; i++) {

            for(Car car : carList) {
                if(car.start == i) {
                    cnt++;
                }

                if(car.end == i) {
                    cnt--;
                }
            }

            if(cnt == 1) {
                sum += a*cnt;
            } else if (cnt == 2) {
                sum += b*cnt;
            } else if (cnt == 3) {
                sum += c*cnt;
            }
        }

        bw.write(sum + "");

        bw.flush();
        br.close();
        bw.close();
    }
}

class Car implements Comparable<Car> {

    int start;
    int end;

    public Car(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Car o) {

        if(this.start == o.start) {
            return this.end - o.end;
        }

        return this.start - o.start;
    }
}