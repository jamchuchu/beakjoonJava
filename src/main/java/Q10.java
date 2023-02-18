import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q10 {
    static int[] arr;
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;

        arr = new int[n];

        arr[0] = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i-1] == 0){
                count *= 2;
            }
        }
        System.out.println(count%10007);
    }


}
