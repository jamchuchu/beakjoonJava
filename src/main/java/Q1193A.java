import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1193A {
    /*
    * 필요한 조건은 몇번 째줄 몇번째 칸인가 이다
    * 해당줄은 무한히 늘어나고 1/2 3/4 5 6/7 8 9 10 ...이런식으로 올라간다
    * 숫자를 받으면 위 리스트의 몇번째 줄에 해당하는지 판별 후 이전 최대값에서 몇칸 더 갔는지 판단 ROW, COL
    * 칸당 3째줄 예시 -> 1/3 2/2/ 3/1 이므로 -> 1/ROW 에서 칸이 올라갈 때마다 1+i/ row-i 임
    * 정방향이 아니라 지그재그 임으로 줄을 2로 나눠서 짝 홀 판단한 다음에 기준에 맞춰 출력
    */
    static int row, col;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        int i = 1;
        while (sum < 10000000) {
            sum += i;
            list.add(sum);
            i++;
        }


        int j = 0;
        while (true) {
            if(num == 1){
                row = 1;
                col = 1;
                break;
            }
            if (num > list.get(j)) {
                j++;
                continue;
            }
            if (num <= list.get(j)) {
                row = j + 1;
                col = num - list.get(j - 1);
                break;
            }
        }

        int answerA = 1;
        int answerB = row;

        for (int k = 1; k < col; k++) {
            answerA++;
            answerB--;
        }

        if(j % 2 == 0) {
            System.out.println(answerB + "/" + answerA);
        }else{
            System.out.println(answerA + "/" + answerB);

        }
    }
}
