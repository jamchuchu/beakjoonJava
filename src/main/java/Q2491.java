import java.util.Scanner;

public class Q2491 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer =0;
        int[][] arr =  new int[3][num];
        if(num > 2) {
            for(int i = 0; i< num; i++) {
                arr[0][i] = sc.nextInt();
                if (i == 0) {
                    arr[1][i] = 1;
                    arr[2][i] = 1;
                    continue;
                }
                if (arr[0][i] >= arr[0][i - 1]) {
                    arr[1][i] = arr[1][i - 1] + 1;
                }else{
                    arr[1][i] = 1;
                }
                if (arr[0][i] <= arr[0][i - 1]) {
                    arr[2][i] = arr[2][i - 1] + 1;
                }else{
                    arr[2][i] = 1;
                }
                answer = Math.max(answer, Math.max(arr[1][i], arr[2][i]));
            }
            System.out.println(answer);
        }else{
            System.out.println(num);
        }
    }
}
