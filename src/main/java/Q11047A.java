import java.util.Scanner;

public class Q11047A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[n-1-i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int b = k / a[i];
            if(b > 0){
                k -= b * a[i];
                count += b;
            }
        }

        System.out.println(count);

    }
}
