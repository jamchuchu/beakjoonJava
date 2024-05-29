import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1924 {
/*
* 달별로 최대일을 입력받는다
* 월과 일을 입력받은 후 앞의 일들을 모두 더해 0월 0일에서 0일로 만든다
* 7로 나눈후 값에 따라 요일 판정
* */
    static int a,b;
    static String answer;
    static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int[] sumDays = new int[13];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i = 1 ; i< 13; i++){
            sumDays[i] = sum;
            sum += days[i];
        }
        b += sumDays[a];
        int dayType = b%7;
        answer = "";

        checkDayType(dayType);

        System.out.println(answer);
    }

    static String checkDayType(int dayType){
        if(dayType == 1){
            answer = "MON";
        }else if(dayType == 2){
            answer = "TUE";
        }else if(dayType == 3){
            answer = "WED";
        }else if(dayType == 4){
            answer = "THU";
        }else if(dayType == 5){
            answer = "FRI";
        }else if(dayType == 6){
            answer = "SAT";
        }else if(dayType == 0){
            answer = "SUN";
        }
        return answer;
    }
}
