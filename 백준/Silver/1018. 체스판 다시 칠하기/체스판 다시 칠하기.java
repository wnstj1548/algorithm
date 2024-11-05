import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] array = new boolean[n][m];
        boolean[][] whiteBoard = new boolean[8][8];
        boolean[][] blackBoard = new boolean[8][8];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i % 2 == 0 && j % 2 == 0) {
                    whiteBoard[i][j] = true;
                    blackBoard[i][j] = false;
                } else if (i % 2 != 0 && j % 2 != 0){
                    whiteBoard[i][j] = true;
                    blackBoard[i][j] = false;
                } else {
                    whiteBoard[i][j] = false;
                    blackBoard[i][j] = true;
                }
            }
        }

        for(int i = 0; i<n; i++) {
            char[] charArray = br.readLine().toCharArray();

            for(int j = 0; j<m; j++) {
                if(charArray[j] == 'W') {
                    array[i][j] = true;
                } else {
                    array[i][j] = false;
                }
            }
        }

        int min = 64;

        if(n-8 > 0 && m-8 > 0) {
            for(int i = 0; i<n-7; i++) {
                for(int j = 0; j<m-7; j++) {
                    boolean[][] subArray = getSubArray(array, i, j);
                    int temp = Math.min(countMismatch(subArray, whiteBoard), countMismatch(subArray, blackBoard));
                    min = Math.min(min, temp);
                }
            }
        } else if(n > 8) {
            for(int i = 0; i<n-7; i++) {
                boolean[][] subArray = getSubArray(array, i, 0);
                int temp = Math.min(countMismatch(subArray, whiteBoard), countMismatch(subArray, blackBoard));
                min = Math.min(min, temp);
            }
        } else if(m > 8) {
            for(int i = 0; i<m-7; i++) {
                boolean[][] subArray = getSubArray(array, 0, i);
                int temp = Math.min(countMismatch(subArray, whiteBoard), countMismatch(subArray, blackBoard));
                min = Math.min(min, temp);
            }
        } else {
            boolean[][] subArray = getSubArray(array, 0, 0);
            int temp = Math.min(countMismatch(subArray, whiteBoard), countMismatch(subArray, blackBoard));
            min = Math.min(min, temp);
        }

        bw.write(min+"\n");

        bw.flush();
        bw.close();
    }

    public static boolean[][] getSubArray(boolean[][] array, int n, int m) {

        boolean[][] subArray = new boolean[8][8];

        for(int i = 0; i<8; i++) {
            for(int j = 0; j<8; j++) {
                subArray[i][j] = array[i+n][j+m];
            }
        }

        return subArray;
    }

    public static int countMismatch(boolean[][] array, boolean[][] board) {

        int count = 0;

        for(int i =0; i<8; i++) {
            for(int j = 0; j<8; j++) {
                if(array[i][j] != board[i][j]) {
                    count ++;
                }
            }
        }

        return count;
    }

    public static boolean[][] deepCopy(boolean[][] original) {

        boolean[][] copy = new boolean[8][8];

        for (int i = 0; i < original.length; i++) {
            for(int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }

        return copy;
    }
}
