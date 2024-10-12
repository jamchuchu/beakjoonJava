import java.util.Scanner;

public class Q1157 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[(int) a.charAt(i) - 97]++;
        }

        boolean flag = false;
        int max = 0;


        for(int i= 0 ; i< 26; i++){
            if(max == arr[i]){
                flag = true;
                break;
            }else{
                max = arr[i];

            }
        }



    }
}
