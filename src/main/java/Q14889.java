import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Q14889{

    static int[][] arr;
    static boolean[][] v;

    static int num;
    static int A;
    static int B;
    static List<Integer> power;

    public static void main(String[] args){

        Scanner sc =  new Scanner(System.in);
        num = sc.nextInt();

        arr = new int[num][num];
        for(int i =0; i< num; i++){
            for(int j=0; j<num; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        v = new boolean[num][num];
        power = new ArrayList<>();

        dfs(0);

        System.out.println(power);
        System.out.println(Collections.min(power));
    }

    static void dfs(int depth){
        if(depth == num){
            power.add(Math.abs(A-B));
            return;
        }
        if(depth >= num/2){
            for(int i =1; i< num; i++){
                if(!v[depth][i]){
                    v[depth][i] = true;
                    v[i][depth] = true;
                    B += arr[depth][i];
                    B += arr[i][depth];


                    dfs(depth+1);


                    v[depth][i] = false;
                    v[i][depth] = false;
                }
            }
        }else{
            for(int i =1; i< num; i++){

                if(!v[depth][i]){
                    v[depth][i] = true;
                    v[i][depth] = true;
                    A += arr[depth][i];
                    A += arr[i][depth];

                    dfs(depth+1);

                    v[depth][i] = false;
                    v[i][depth] = false;

                }
            }
        }


    }
}