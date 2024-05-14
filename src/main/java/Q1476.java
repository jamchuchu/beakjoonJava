import java.io.IOException;
import java.util.Scanner;

public class Q1476 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int answer = 1;

        int a = 1;
        int b = 1;
        int c = 1;

        while(true){
           if(e == a && s == b && m == c){
               break;
           }
           answer++;
           if(a >= 15){
               a = 1;
           }else{
               a++;
           }
           if(b >= 28){
               b = 1;
           }else{
               b++;
           }
           if(c >= 19){
               c = 1;
           }else{
               c++;
           }
//            System.out.println(a + " " + b + " " + c);
        }

        System.out.println(answer);

    }
}
