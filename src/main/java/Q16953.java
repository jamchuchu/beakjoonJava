import java.util.Scanner;

public class Q16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int count = 1;

        //1. 거꾸로 생각하기
        /*
        * 끝이 1이 아닌 짝수 이면 2로 나눈다
        * 끝이 1이고 a보다 크면 1을 빼고 10으로 나눈다
        * a 보다 작으면 이전 연산을 다시한다
        **/


        while(a < b){
            if( b % 2 ==0){
                b /= 2;
            }else if(b % 10 == 1){
                b = (b -1)/10;
            }else{
                break;
            }
            count++;
        }

        if(b == a){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}
