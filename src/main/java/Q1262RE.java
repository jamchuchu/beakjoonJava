import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Q1262RE {
    public static void main(String[] args) throws IOException {

        Scanner sc =  new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = sc.nextLine().split(" ");
        int num = Integer.parseInt(str[0]);
        int x1 = Integer.parseInt(str[1]);
        int y1 = Integer.parseInt(str[2]);
        int x2 = Integer.parseInt(str[3]);
        int y2 = Integer.parseInt(str[4]);
        char[] alpha = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        char[][] mapOrg = new char[(2*num)-1][(2*num)-1];


        for(int i =0; i< num; i++){//12345
            for(int j=0; j< num-i-1; j++){
//                System.out.print(".");
                mapOrg[i][j] = '.';
            }
            for(int j=0; j< i+1; j++){
//                System.out.print(alpha[num-1-j]);
                mapOrg[i][num-i-1+j] =alpha[num-1-j];
            }
            for(int j=0; j< i; j++){
//                System.out.print(alpha[num-(i-j)]);
                mapOrg[i][num+j] = alpha[num-(i-j)];

            }
            for(int j=0; j< num-i-1; j++){
//                System.out.print(".");
                mapOrg[i][num+i+j] = '.';

            }
//            System.out.println();
        }

        for(int k =0; k< num; k++){//6789
            if(k == 0){
                continue;
            }
            int i = num-k-1;
            for(int j=0; j< num-i-1; j++){
//                System.out.print(".");
                mapOrg[num+k-1][j] = '.';
            }
            for(int j=0; j< i+1; j++){
//                System.out.print(alpha[num-1-j]);
                mapOrg[num+k-1][num-i-1+j] =alpha[num-1-j];
            }
            for(int j=0; j< i; j++){
//                System.out.print(alpha[num-(i-j)]);
                mapOrg[num+k-1][num+j] = alpha[num-(i-j)];

            }
            for(int j=0; j< num-i-1; j++){
//                System.out.print(".");
                mapOrg[num+k-1][num+i+j] = '.';

            }
//            System.out.println();
        }

//
//        for(int i =0; i < mapOrg.length; i++) {//6789
//            for (int j = 0; j < mapOrg.length; j++) {//6789
//                System.out.print(mapOrg[i][j]);
//            }
//            System.out.println();
//        }


        int length = mapOrg.length;

        for(int i =0; i < x2+1; i++) {//6789
            for (int j = 0; j < y2+1; j++) {//6789
                bw.write(mapOrg[i%length][j%length]);
            }
            bw.write("\n");
        }

        bw.flush();

    }
}
