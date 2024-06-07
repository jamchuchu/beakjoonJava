import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3107 {
    static String str;
    static String answer = "";

    static String[] list;

    public static void main(String[] args) throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         str = reader.readLine();
         str = str.replace("::", ":zero:");

         list = str.split(":");

//        for(int i = 0 ; i< list.length; i++){
//            System.out.println(list[i] + " ");
//        }
//
         for(int i = 0 ; i< list.length; i++){
             while(list[i].length() != 4){
                 list[i] = "0" + list[i];
             }
         }

         int zeroCount = 8 - list.length +1;

        for(int i = 0 ; i< list.length; i++){
            if(list[i].equals("zero")){
                for(int j = 0 ; j< zeroCount; j++){
                    answer += "0000:";
                }
            }else{
                answer += list[i] + ":";
            }
        }
//
//         for(int i = 0 ; i< list.length; i++){
//            System.out.println(list[i] + " ");
//         }
        System.out.println(answer.substring(0, 39));

    }

}
