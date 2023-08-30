import java.util.Scanner;

public class Q1788 {

    static long[] fib;

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();

        long answer = 0;


        if(num == 0){
            System.out.println(0);
            System.out.println(0);
        }else if(num == 1){
            System.out.println(1);
            System.out.println(1);
        }else if(num > 1){
            fib = new long[num+1];
            fib[1] = 1;
            for(int i = 2; i < num+1; i++){
                fib[i] = (fib[i-1] + fib[i-2])%1000000000;
            }
            System.out.println(1);
            System.out.println(fib[num]);
        }else{
            fib = new long[(num*-1)+2];
            fib[0] = 1;
            fib[1] = 0;
            for(int i = 2; i < fib.length; i++){
                fib[i] = (fib[i-2] - fib[i-1])%1000000000;
            }
            answer = fib[(num*-1)+1];
            if(answer > 0){
                System.out.println(1);
                System.out.println(answer);
            }else{
                System.out.println(-1);
                System.out.println((answer*-1));
            }
        }



    }

}
