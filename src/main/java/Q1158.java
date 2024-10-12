import java.io.*;
import java.util.ArrayDeque;

public class Q1158 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i = 0 ; i <  a; i++){
            que.add(i+1);
        }

        System.out.print("<");
        while(true){
            for(int i = 0 ; i < b-1; i++){
                que.add(que.poll());
            }
            System.out.print(que.poll());
            if(que.isEmpty()){
                break;
            }else{
                System.out.print(", ");
            }
        }
        System.out.print(">");


//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
