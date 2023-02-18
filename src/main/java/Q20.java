import java.util.*;

class Q20{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);

        int a = sc.nextInt();
        float c = 0;


        for(int i = 0 ; i < a; i++ ){
            int b =  sc.nextInt();
            c = 0;
            for(int j = 0; j < b; j++){
                float num = sc.nextFloat();
                c += num;
            }
            float d = c/Float.valueOf(b); // 평균



            float e = Math.round((d*1000)/1000.00);
        }


    }
}