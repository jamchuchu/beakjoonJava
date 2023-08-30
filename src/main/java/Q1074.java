import java.io.*;
import java.util.StringTokenizer;


public class Q1074 {

    static int number;
    static int r;
    static int c;
    static BufferedWriter bf;
    public static void main(String[] args)throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        bf = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(sc.readLine());

        int num = Integer.parseInt(st.nextToken());//3
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        dfs(0, num-1, 0, 0);
        bf.flush();


    }

    public static void dfs(int depth, int target, int row, int col) throws IOException {
        if(depth ==  target){
            if(0 == r && 0 ==c){
                bf.write(String.valueOf(number));
            }else if(0 == r && 1 ==c){
                bf.write(String.valueOf(number+1));
            }else if(1 == r && 0 ==c){
                bf.write(String.valueOf(number+2));
            }else if(1 == r && 1 ==c){
                bf.write(String.valueOf(number+3));
            }else {
                number += 4;
            }
            return;
        }

        int smallSize = (int)Math.pow(2,target-depth);

        if(r < smallSize) {
            c -= smallSize;
            number += smallSize*smallSize;
        }else if(c < smallSize) {
            number += smallSize*smallSize*2;
            r -= smallSize;
        }else{
            number += smallSize*smallSize*3;
            r -= smallSize;
            c -= smallSize;
        }
        dfs(depth+1, target, r, c);

    }


}
