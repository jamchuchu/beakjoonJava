import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q11729 {

    static List<Integer>[] list = new ArrayList[3];
    static int count = 0;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num =  sc.nextInt();
        for(int i = 0; i < 3; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < num; i++){
            list[0].add(i+1);
        }

        f(num, 1, 3);
    }

    static void f(int num, int depth, int target){
       if(depth == 1){
           f(num-1, depth+1, 1);
       }
       if(num == depth) {
           move(0, target);
       }
       if(depth == num+1){
           f(num-1, depth+1, 2);
       }
       if(depth == num*2){
           return;
       }
    }


    static void move(int fir, int sec){
        int move = list[fir].remove(0);
        list[sec].add(move);
        System.out.println((fir +1) + " " + (sec+1));
    }
}
