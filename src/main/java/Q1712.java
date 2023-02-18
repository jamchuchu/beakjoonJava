import java.util.*;
import java.io.*;

class Q1712{
    public static void main(String[] args)throws IOException{

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String[] arr = bf.readLine().split(" ");
//
//        int a = Integer.parseInt(arr[0]);
//        int b = Integer.parseInt(arr[1]);
//        int c=  Integer.parseInt(arr[2]);
//        int answer = 0;
//
//        if(b >= c){
//            System.out.println(-1);
//        }else{
//            answer = a/(c-b);
//        }
//
//        while(b < c){
//
//            int out = a + (b*answer);
//            int in = c*answer;
//
//            int total = in - out;
//            if(total > 0){
//                System.out.println(answer);
//                break;
//            }
//            answer++;
//        }
//
//
//


                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String[] arr = bf.readLine().split(" ");

                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int c=  Integer.parseInt(arr[2]);
                int answer = 0;

                if(b >= c){
                    System.out.println(-1);
                }else{
                    answer = (a/(c-b))+1;
                }

                System.out.println(answer);


    }
}