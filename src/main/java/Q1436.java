import java.util.Scanner;

public class Q1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 666; i< Integer.MAX_VALUE; i++){
            if(String.valueOf(i).contains("666")){
                n--;
                if(n == 0){
                    System.out.println(i);
                }
            }
        }

    }
}
