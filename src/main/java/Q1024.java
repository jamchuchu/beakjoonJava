import java.util.Scanner;

public class Q1024 {
    /*
    * L 이 2 인데 N 이 짝수면 불가
    * 짝수이면(18) 나눠서 두개 합 9(4,5 부터) 되는것 들의 모임
    *
    * 불가판정: L을 2로 나눈수가 나누어떨어지면 가능
    * 나누어 떨어지고 몫이 L을 2로 나눈수 보다 커야함
    * N/L/2의
    *
    * 처음 + 끝(R) * L/2  = N 이 되는 자연수가 있는가? 없다면 L up
    *  있다면 R/2 이 L/2 -1 보다 같거나 큰가? 아니면 -1
    * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        while(true){
            int temp = 0;
            if(L == 2 & N % 2 == 0){
                L++;
                continue;
            }
            temp = N/L;
            int start = 0;
            if(L % 2 == 1){
                start = temp - (L-1)/2;
            }else{
                start = temp - (L/2 - 1);
            }
            if(start < 0){
                System.out.println(-1);
                break;
            }else{
                for(int i = 0; i<L; i++){
                    System.out.print(start + i + " ");
                }
                break;
            }


        }



    }
}
