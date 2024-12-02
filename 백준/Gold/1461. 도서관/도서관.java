import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> minusList = new ArrayList<>();
        List<Integer> plusList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp < 0) {
                minusList.add(temp);
            } else {
                plusList.add(temp);
            }
        }

        plusList.sort(Collections.reverseOrder());
        Collections.sort(minusList);

        int tempMax = Integer.MIN_VALUE;

        int i = 0;
        while(i < minusList.size()) {

            if(i != 0 && i % m == 0) {
                resultList.add(tempMax);
                tempMax = Integer.MIN_VALUE;
            }

            tempMax = Math.max(tempMax, Math.abs(minusList.get(i)));

            i++;
        }

        if(tempMax != Integer.MIN_VALUE) {
            resultList.add(tempMax);
            tempMax = Integer.MIN_VALUE;
        }

        i = 0;

        while(i < plusList.size()) {

            if(i != 0 && i % m == 0) {
                resultList.add(tempMax);
                tempMax = Integer.MIN_VALUE;
            }

            tempMax = Math.max(tempMax, Math.abs(plusList.get(i)));

            i++;
        }

        if(tempMax != Integer.MIN_VALUE) {
            resultList.add(tempMax);
        }

        Collections.sort(resultList);

        int sum = 0;

        for(int j = 0; j < resultList.size() - 1; j++) {
            sum += resultList.get(j) * 2;
        }

        sum += resultList.get(resultList.size() - 1);

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
