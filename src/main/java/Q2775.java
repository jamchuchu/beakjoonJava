import java.util.*;

class Q2775{
    static int[][] arr;

    public static void main(String[] args){
        int num = 0;
        int floor = 0;
        int h = 0;
        int temp = 0;

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        for(int k =0; k< num; k++){
            floor = sc.nextInt();
            h = sc.nextInt();

            arr = new int[floor+1][h+1];

            for(int i = 0; i< h+1; i++){
                arr[0][i] = i;
            }
            for(int i = 0; i< floor+1; i++){
                arr[i][1] = 1;
            }


            for(int i = 1; i< h+1; i++){
                for(int j = 1; j < floor+1; j++){
                    temp = arr[j][i-1]+arr[j-1][i];
                    arr[j][i] = temp;
                }
            }

            System.out.println(arr[floor][h]);

        }

    }

}