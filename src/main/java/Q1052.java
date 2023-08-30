import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1052 {
    /*
    2의 n승 중 제일 큰것으로 나눠두고
    나머지에 대해서 다시계산 몫이 1일때 count
    count가 목표치에 도달하면
    다음 값보다 큰 아이에게 차만큼 구해줌

    */

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int count = 0;
        int N = sc.nextInt();
        int K = sc.nextInt();
        int Norg = N;
        int buy = 0;
        while(true) {
            if(N%2 == 1){
                count++;
            }
            N = N / 2;
            if(N == 0){
                if(count <= K){
                    break;
                }else{
                    buy++;
                    Norg++;
                    N = Norg;
                    count = 0;
                }
            }
        }
        System.out.println(buy);
    }
}
