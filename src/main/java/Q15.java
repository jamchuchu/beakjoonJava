import java.util.Scanner;

public class Q15 {
    static long[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();

        arr = new long[max];



        try {

            arr[0] = 1;
            arr[1] = 2;

            for (int i = 2; i < max; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2])%10007;
            }
        }catch(Exception e){}

        System.out.println(arr[max-1]);

    }



}
