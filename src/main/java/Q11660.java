import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //선언

        String[] str = sc.readLine().split(" ");
        int x = Integer.parseInt(str[0])+1;
        int y = Integer.parseInt(str[1])+1;

        int[][] list = new int[x][x];

        for(int i = 0; i< x; i++){
            str = sc.readLine().split(" ");
            for(int j =0; j<x; j++){
                list[i][j] = Integer.parseInt(str[j]);
            }
        }


        int[][] list2 = new int[x][x];

        list2[0][0] = list[0][0];

        for(int i =1; i< x ; i++){
            list2[0][i] = list2[0][i-1] + list[0][i];
        }

        for(int i =1; i< x ; i++){
            list2[i][0] = list2[i-1][0] + list[i][0];
        }

        for(int i = 1; i< x; i++){
            for(int j =1; j<x; j++){
                list2[i][j] = list2[i-1][j] + list2[i][j-1] - list2[i-1][j-1] + list[i][j];
            }
        }



        for(int i = 0; i< x; i++){
            for(int j =0; j<x; j++){
                System.out.print(list2[i][j] + " ");
            }
            System.out.println();
        }


        int answer = 0;

        for(int i = 0; i< y; i++){
            String str1 = sc.readLine();
            str = str1.split(" ");

            if(str[0].equals(str[2]) && str[1].equals(str[3])){
                answer = list[Integer.parseInt(str[2])-1][Integer.parseInt(str[3])-1];
                System.out.println(answer);
                continue;
            }else{
                answer = list2[Integer.parseInt(str[2])-1][Integer.parseInt(str[3])-1];
            }

            if(Integer.parseInt(str[0])-2 >= 0 && Integer.parseInt(str[1])-2 >= 0){
                answer += (list2[Integer.parseInt(str[0])-2][Integer.parseInt(str[1])-2]
                        -list2[Integer.parseInt(str[0])-2][Integer.parseInt(str[3])-1]
                        -list2[Integer.parseInt(str[2])-1][Integer.parseInt(str[1])-2]);
            }else if(Integer.parseInt(str[0])-1 == 0 && Integer.parseInt(str[1])-1 == 0){
                System.out.println(answer);
                continue;
            }else if(Integer.parseInt(str[0])-1 == 0){
                answer -= list2[Integer.parseInt(str[2])-1][Integer.parseInt(str[1])-2];
            }else if(Integer.parseInt(str[1])-1 == 0){
                answer -= list2[Integer.parseInt(str[0])-2][Integer.parseInt(str[3])-1];
            }


            System.out.println(answer);
        }


    }
}
