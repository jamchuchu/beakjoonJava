import java.io.*;
import java.util.Scanner;

public class Q1913 {
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};//up, left, right, down
    public static void main(String[] args) throws IOException {
        BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] str = sc.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int target = Integer.parseInt(str[1]);

        int[][] arr =  new int[N][N];


        //세로
        for(int i =0; i< N/2+1; i++){
            for(int j = i; j<N-i; j++){
                arr[j][i] = (int) Math.pow(N-(i*2),2)-j+i;
            }
        }
        //가로
        for(int i =0; i< N/2+1; i++){
            int temp = arr[i+1][i+1];
            for(int j =i+1; j<N-i;j++){
                arr[i][j] = temp+j-i;
            }
        }
        //아래
        for(int i = 0; i< N/2; i++){//0,1,2
            int temp = arr[N/2+i+1][N/2-i-1];//(3,2)
            for(int j =0; j< ((i+2)*2)-2; j++){
                arr[N/2+i+1][N/2-i+j] = temp - j-1;
            }
        }
        //오른쪽
        for(int i = 0; i< N/2; i++){//0,1,2
            int temp = arr[N/2-i-1][N/2+i+1];//(2,4)
            for(int j =0; j< (i+1)*2-1; j++){
                arr[N/2-i+j][N/2+i+1] = temp + j+1;
            }
        }

        int x = 0;
        int y = 0;
        for(int i=0; i< N; i++){
            for(int j=0; j< N; j++) {
                if(arr[i][j]==
                        target){
                    x = i+1;
                    y = j+1;
                }
                bw.write(arr[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.write(x + " " + y);
        bw.flush();


    }

}
