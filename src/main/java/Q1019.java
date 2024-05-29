import java.util.Scanner;

public class Q1019 {
    /*
    * 브루트포스 써봄 -- 시간초과 예상됨
    *
    *
        *

     * */
    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            int end = sc.nextInt();
            int[] list = new int[10];
            for (int i = 1; i <= end; i++) {
                String n = String.valueOf(i);
//                for (int j = 0; j < n.length(); j++) {
//                    for (int k = 0; k < 10; k++) {
//                        if (Integer.parseInt(String.valueOf(n.charAt(j))) == k) {
//                            list[k]++;
//                        }
//                    }
//                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
        }


    }

}
