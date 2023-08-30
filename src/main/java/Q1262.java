import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Q1262 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = sc.nextLine().split(" ");
        int num = Integer.parseInt(str[0]);
        int x1 = Integer.parseInt(str[1]);
        int y1 = Integer.parseInt(str[2]);
        int x2 = Integer.parseInt(str[3]) + 1;
        int y2 = Integer.parseInt(str[4]) + 1;
        char[] alpha = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


        int number = 2 * num - 1;
        while (true) {
            for (int i = 0 ; i < num; i++) {//56789
//            while(start < number){
                for (int j = 0; j < num - i - 1; j++) {
                    bw.write('.');
                }
                for (int j = 0; j < i + 1; j++) {
                    bw.write(alpha[(num - 1 - j) % num]);
                }
                for (int j = 0; j < i; j++) {
                    bw.write(alpha[(num - (i - j)) % num]);
                }
                for (int j = 0; j < num - i - 1; j++) {
                    bw.write('.');
                }
                bw.write('\n');
            }


            for (int k = 0; k < num; k++) {//6789
                if (k == 0) {
                    continue;
                }
                int p = num - k - 1;
                for (int j = 0; p < num - p - 1; j++) {
                    bw.write('.');

                }
                for (int j = 0; j < p + 1; j++) {
                    bw.write(alpha[(num - 1 - j) % num]);

                }
                for (int j = 0; j < p; j++) {
                    bw.write(alpha[(num - (p - j)) % num]);
                }
                for (int j = 0; j < num - p - 1; j++) {
                    bw.write('.');

                }
                bw.write('\n');


            }
            break;

        }
        bw.flush();

    }
}



