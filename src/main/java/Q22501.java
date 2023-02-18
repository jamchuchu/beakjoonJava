import java.util.*;

class Q22501
{

    static int count;
    static int answer;
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int num =sc.nextInt();
        sc.nextLine();

        for(int i =0; i< num; i++){
            String str = sc.nextLine();
            System.out.println(f(str) + " " + count);
            count = 0;
            answer = 0;
        }
    }

    static int f(String str){
        count++;
        String[] arr = str.split("");
        int length = arr.length;

        if(length == 0 || length == 1){
            answer = 1;
            return answer;
        }else{
            if(arr[0].equals(arr[arr.length-1])){
                String strNext = "";
                for(int i = 0; i< arr.length-2; i++){
                    strNext += arr[i+1];
                }
                f(strNext);
            }else{
                return answer;
            }
        }
        return answer;
    }

}