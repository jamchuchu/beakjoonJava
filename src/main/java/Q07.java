import java.sql.SQLOutput;
import java.util.Scanner;

public class Q07 {
    public static void main(String[] args) {
        int[] months = new int[]
                {31, 28, 31, 30, 31 ,30, 31, 31, 30, 31, 30, 31};
        Scanner sc =  new Scanner(System.in);
        String[] target = sc.nextLine().split(" ");

        int month = Integer.parseInt(target[0]);
        int day = Integer.parseInt(target[1]);
        int week = 0;

        for(int i = 0; i< month-1; i++){
            day += months[i];
        }

        week = day % 7;
        String answer = null;

        if(week == 1){
            answer = "MON";
        }else if(week == 2){
            answer = "TUE";
        }else if(week == 3){
            answer = "WED";
        }else if(week == 4){
            answer = "THU";
        }else if(week == 5){
            answer = "FRI";
        }else if(week == 6){
            answer = "SAT";
        }else{
            answer = "SUN";
        }

        System.out.println(answer);







    }
}
