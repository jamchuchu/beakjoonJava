import java.util.Arrays;
import java.util.Scanner;

public class Q2512 {
    static int num;
    static int total;
    static int[] money;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        sc.nextLine();

        String[] str = sc.nextLine().split(" ");
        money = new int[num];
        int max = 0;
        int totalMoney = 0;// 모두에게 전부 다 줄때 금액
        for(int i =0; i< num; i++){
            money[i] = Integer.parseInt(str[i]);
            max = Math.max(max,money[i]);
            totalMoney += money[i];

        }
        total = sc.nextInt();

        if(totalMoney < total){
            System.out.println(max);
        }else {
            binary(0, max);
        }
    }

    static void binary(int start, int end){
        if(start >= end){
            System.out.println(end);
            return;
        }

        int mid = (start+end)/2;

//        if(mid == end){
//            System.out.println(end);
//            return;
//        }else if(mid == start){
//            System.out.println(start);
//            return;
//        }

        int temp = 0;
        int temp2 = 0;

        for(int i =0; i< num; i++){
            if (money[i] > mid){
                temp += mid;
                temp2 += mid+1;
            }else{
                temp += money[i];
                temp2 += money[i];
            }
        }

//        System.out.println(temp + " " + start +" "+ end+" "+mid);

        if(temp > total){
            binary(start, mid);
        }else if(temp < total){
            if(temp2 > total){
                System.out.println(mid);
            }else{
                binary(mid+1, end);
            }
        }else{
            System.out.println(mid);
        }
    }
}
