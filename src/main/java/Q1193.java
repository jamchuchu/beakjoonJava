import java.util.*;

class Q1193{
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int num =  sc.nextInt();
        int x = 0;
        int i = 1;

        while(x < num){
            x = x+i;
            if(x >= num){
                break;
            }
            i++;
        }


        int sub = x - num;

        int dx = i-sub;
        int dy = i+1-dx;

        System.out.print(dx+"/"+dy);











    }
}