import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] array = br.readLine().replace("c=", "?")
                        .replace("c-", "?")
                        .replace("dz=", "?")
                        .replace("d-", "?")
                        .replace("lj", "?")
                        .replace("nj","?")
                        .replace("s=", "?")
                        .replace("z=", "?")
                        .toCharArray();

        bw.write(array.length + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}


