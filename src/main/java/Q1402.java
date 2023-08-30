import java.util.Scanner;

public class Q1402 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int temp = 0;
        int num = sc.nextInt();
        for(int i =0; i<num; i++){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
            temp += (i+1)*5000;


        }
        System.out.println(temp);


    }
}
