import java.util.Scanner;

public class Q1699 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int max = 100001;
            int[] arr = new int[max];
            for (int i = 0; i < max; i++) {
                int a = (int) Math.sqrt(i);
                if (a * a == i) {// 제곱 수
                    arr[i] = 1;
                } else {
                    int min = max;
                    for(int j = 1 ; j<= a; j++){
                        min = Math.min(arr[i - (j * j)], min);
                        if(min == 1){
                            break;
                        }
                    }
                    arr[i] = min + 1;
                }
            }
            System.out.println(arr[n]);

    }

}
