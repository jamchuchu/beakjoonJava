import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q2447 {

    static int originx;
    static int originy;
    static boolean[][] v;
    static String[][] arr;
    static boolean[][] star;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        arr = new String[num][num];
        for(int i = 0; i < num; i++) {
            Arrays.fill(arr[i], " ");
        }
        v = new boolean[num][num];


        star = new boolean[3][3];
        for(int i = 0; i < 3; i++) {
            Arrays.fill(star[i], true);
        }
        star[1][1] = false;


        int depth = 0;
        int temp = num;

        while (temp / 3 != 1) {
            temp /= 3;
            depth++;
        }


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(!v[i][j]) {
                    originx = i;
                    originy = j;
                    star(depth, i, j);
                }
                bw.write(arr[i][j]);

            }
            bw.write("\n");
        }
        bw.flush();

    }

    static void star(int depth, int x, int y) {// depth = 1 -- > 3
        v[x][y] = true;
        if (depth == 0 && star[x][y]) {
            arr[originx][originy] = "*";
            return;
        }
        if (star[(int) (x / (Math.pow(3, depth)))][(int) (y / (Math.pow(3, depth)))]) {
            star(depth - 1, (int) (x % (Math.pow(3, depth))), (int) (y % (Math.pow(3, depth))));
        }
    }
}
