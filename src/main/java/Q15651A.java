import java.io.*;

public class Q15651A {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; //n개중
    static int M; //M
    static int[] select;

    public static void main(String[] args) throws IOException {
        input();
        select = new int[M+1];
        fun(1);

        writer.flush();
    }

    static void input() throws IOException {
        String[] str = reader.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
    }

    static void fun(int depth) throws IOException{
        if(depth == M+1){
            for(int i = 1; i < depth; i++){
                writer.write(select[i] + " ");
            }
            writer.write("\n");
        }else{
            for(int i = 1; i < N+1; i++) {
                select[depth] = i;
                fun(depth + 1);
                select[depth] = 0;

            }
        }
    }


}
