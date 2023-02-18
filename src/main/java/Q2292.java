import java.util.*;

class Q2292{
    public static void main(String[] args){

        List<Long> list = new ArrayList<>();
        long num = 1;
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int i = 1;

        while(num < 1000000001){
            if(a == 1){
                System.out.println(1);
                break;
            }
            num = num + (6*i);
            if(a <= num){
                System.out.println(i+1);
                break;
            }
            i++;
        }

    }
}