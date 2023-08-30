import java.util.Scanner;

public class Q1783 {


    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        Long a = sc.nextLong();
        Long b = sc.nextLong();

        Long answer;


        if(a > 2) {
            if (b < 4) {
                answer = b;
            } else if (b == 4 || b == 5 || b == 6) {
                answer = Long.valueOf(4);
            } else {
                answer = b - 2;
            }
        }else if(a == 2){
            int temp  = (int) ((b-1)/4) * 2 +1 ;
            if((b-1)%4 == 0||(b-1)%4 == 1) {
                answer = Math.min(4,Long.valueOf(temp));
            } else{
                answer = Math.min(4,Long.valueOf(temp)+1);
            }
        }
        else{
            answer =  a;
        }

        System.out.println(answer);
    }

}
