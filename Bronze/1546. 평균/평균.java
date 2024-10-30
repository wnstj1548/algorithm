import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<Integer> intList = new ArrayList<>();
        List<Double> resultList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 1;

        for(int i =0; i < count; i++) {

            int a = Integer.parseInt(st.nextToken());

            if(max < a) {
                max = a;
            }

            intList.add(a);
        }

        for(int i : intList) {
            resultList.add((double)i/max * 100);
        }

        double sum = resultList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        bw.write(sum/count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}