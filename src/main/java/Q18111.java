import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18111 {

    public static void main(String[] args)throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] str = sc.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int block = Integer.parseInt(str[2]);

            int[][] map = new int[x][y];
            int[] count = new int[257];

            for (int i = 0; i < x; i++) {
                str = sc.readLine().split(" ");
                for (int j = 0; j < y; j++) {
                    int temp = Integer.parseInt(str[j]);
                    map[i][j] = temp;
                    count[temp] += 1;
                }
            }

//        for(int i =0; i< x; i++){
//            for(int j =0; j < y; j++){
//                System.out.print(map[i][j]+ " ");
//            }
//            System.out.println();
//        }
//        for(int i =0; i <257; i++){
//            System.out.print(count[i]);
//        }


            int temp = 0;
            int time;
            int answer1 = 0;
            int answer2 = 0;

            for (int i =1; i < 257; i++) {
                answer1 += (i) * count[i] * 2;
            }


            while (temp < 257) {
                time = 0;
                int myblock = 0;

                for (int i = temp + 1; i < 257; i++) {
                    time += (i - temp) * count[i] * 2;
                    myblock += (i - temp) * count[i];
                }
                for (int i = 0; i < temp; i++) {
                    time += (temp - i) * count[i];
                    myblock -= (temp - i) * count[i];
                }

                if (myblock + block < 0) {
                    break;
                }
                if (answer1 >= time) {
                    answer1 = time;
                    answer2 = temp;
                }
                temp++;
            }

            System.out.println(answer1 + " " + answer2);


        }
    }
}

