import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q28278 {

    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i<n; i++){
            int[] temp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            func(temp);
        }
//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static void func(int[] num) throws IOException {
        if(num[0] == 1){
            deque.add(num[1]);
            return;
        }
        if(num[0] == 2){
            if(!deque.isEmpty()) {
                writer.write(deque.pollLast() + "\n");
            }else{
                writer.write(-1+ "\n");
            }
            return;
        }
        if(num[0] == 3){
            writer.write(deque.size()+ "\n");
            return;
        }
        if(num[0] == 4){
            if(deque.isEmpty()){
                writer.write(1+ "\n");
            }else{
                writer.write(0+ "\n");
            }
            return;
        }
        if(num[0] == 5){
            if(!deque.isEmpty()){
                writer.write(deque.peekLast()+ "\n");
            }else{
                writer.write(-1+ "\n");
            }
            return;
        }
    }
}
