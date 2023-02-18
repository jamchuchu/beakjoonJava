import java.util.*;

class Q10872{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num= sc.nextInt();
        System.out.println(f(num));

    }

    static int f(int num){
        if(num == 0 ){
            return 1;
        }else {
            return num * f(num - 1);
        }
    }
}