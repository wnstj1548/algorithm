import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        Set<Integer> plug = new HashSet<>();
        int count = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++) {

            if(plug.contains(arr[i])) {
                continue;
            }

            if(plug.size() < n) {
                plug.add(arr[i]);
                continue;
            }

            int remove = -1;
            int far = -1;

            for(int plugged : plug) {
                int nextUse = Integer.MAX_VALUE;

                //다음에 사용하는지
                for (int j = i + 1; j < k; j++) {
                    if (arr[j] == plugged) {
                        nextUse = j;
                        break;
                    }
                }

                //사용 안하면 제거
                if(nextUse == Integer.MAX_VALUE) {
                    remove = plugged;
                    break;
                }

                //제일 마지막껀지 확인
                if(nextUse > far) {
                    far = nextUse;
                    remove = plugged;
                }
            }

            plug.remove(remove);
            plug.add(arr[i]);
            count++;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}