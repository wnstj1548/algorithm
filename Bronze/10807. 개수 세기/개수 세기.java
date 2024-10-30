import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int search = Integer.parseInt(br.readLine());
        List<Integer> integerList = new ArrayList<>();
        int result = 0;

        for(int i = 0; i < count; i++) {
            integerList.add(Integer.parseInt(st.nextToken()));
        }

        for(Integer i : integerList) {
            if(i.equals(search)) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}