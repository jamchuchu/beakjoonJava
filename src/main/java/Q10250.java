import java.util.*;

class Q10250{
    public static void main(String[] args){

        int x = 0;
        int y = 0;
        int peo =0;
        int num = 0;
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();

        for(int i=0; i< num; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            peo = sc.nextInt();

            a= peo % x;

            b= (peo / x)+1;

            if(a == 0){
                System.out.println(x*100 + (b-1));
            }else {
                System.out.println(a*100 + b);
            }
        }



    }
}