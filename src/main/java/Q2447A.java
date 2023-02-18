import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Q2447A {

    static int originx;
    static int originy;
    static int originDepth;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        String[][] arr = new String[num][num];
        for(int i = 0; i < num; i++) {
            Arrays.fill(arr[i], " ");
        }

        boolean[][] star = new boolean[3][3];
        for(int i = 0; i < 3; i++) {
            Arrays.fill(arr[i], true);
        }
        star[1][1] = false;

        int depth = 0;
        int temp = num;

        while (temp / 3 != 1) {
            temp /= 3;
            depth++;
        }
        originDepth = depth;


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                originx = i;
                originy = j;
                star(arr, star, depth, i, j);
                bw.write(arr[i][j]);

            }
            bw.write("\n");
        }
        bw.flush();

    }

    static void star(String[][] arr, boolean[][] star,  int depth, int x, int y) {// depth = 1 -- > 3
        if (depth == 1 && star[x][y]) {
            for(int i = 0; i < originDepth; i++) {
                for(int j = 0; j < originDepth; j++) {
                    arr[(int) (x+Math.pow(3, i))][(int) (y+Math.pow(3, j))] = "*";
                }
            }
            return;
        }
        if (star[(int) (x / (Math.pow(3, depth)))][(int) (y / (Math.pow(3, depth)))]) {
            star(arr, star, depth - 1, (int) (x % (Math.pow(3, depth))), (int) (y % (Math.pow(3, depth))));
        }
    }
}
