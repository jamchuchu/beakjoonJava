import java.util.*;

class Q2563{
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);

        int count = 0;

        int num =  sc.nextInt();// 종이 개수
        boolean[][] paper = new boolean[100][100];

        for(int i = 0; i < num; i++){
            int y = sc.nextInt()-1;
            int x = sc.nextInt()-1;

            for(int j = 0; j < 10; j++){
                for(int k = 0; k< 10; k++){
                    paper[x+j][y+k] = true;
                }
            }
        }

        for(int j = 0;j < 100; j++){
            for(int k = 0; k< 100; k++){
                if(paper[j][k]){
                    count++;
                }
            }
        }

        System.out.println(count);


    }
}