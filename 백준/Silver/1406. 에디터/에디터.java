import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] array = br.readLine().toCharArray();
        List<Character> charList = new LinkedList<>();

        for(int i = 0; i < array.length; i++){
            charList.add(array[i]);
        }

        ListIterator<Character> iter = charList.listIterator();

        while(iter.hasNext()) {
            iter.next();
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("P")) {
                iter.add(st.nextToken().charAt(0));
            } else if(s.equals("L")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                }
            } else if(s.equals("D")) {
                if(iter.hasNext()) {
                    iter.next();
                }
            } else if(s.equals("B")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }

        for(Character c : charList) {
            bw.write(c);
        }
        bw.newLine();

        bw.flush();
        br.close();
        bw.close();
    }
}
