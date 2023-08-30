import java.util.Scanner;

public class Q2828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();
        int num = sc.nextInt();

        int start = 1;
        int end = M;
        int count = 0;

        for(int i  = 0; i < num; i++){
            int target =  sc.nextInt();
            int move = 0;
            if(target < start){ // 2  ,3
                move = start - target; //1
                start = target;//2
                end -= move;
                count += move;
            }else if(target > end){//5 ,4
                move = target-end;
                end = target;
                start += move;
                count+= move;
            }
        }

        System.out.println(count);
    }
}
