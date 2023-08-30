import java.io.*;
import java.util.*;

public class Q18258 {
    static Deque<Integer> deq;
    public static void main(String[] args) throws IOException {
        BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
         deq = new LinkedList<>();

        int num = Integer.parseInt(sc.readLine());

        for(int i = 0; i < num; i++) {
            String str = sc.readLine();
            String[] temp = str.split(" ");
            if (temp[0].equals("push")) {
                push(temp[1]);
            }else{
                bw.write(question(temp[0])+"\n");
            }
        }
        bw.flush();

    }
    static void push(String num){
        deq.offer(Integer.parseInt(num));
    }

    static int question(String str){
        int answer = -1;
        if(str.equals("pop")){
            if(!deq.isEmpty()) {
                answer = deq.pop();
            }
        }else if(str.equals("size")){
            answer = deq.size();
        }else if(str.equals("empty")){
            if(deq.isEmpty()){
                answer = 1;
            }else{
                answer = 0;
            }
        }else if(str.equals("front")){
            if(!deq.isEmpty()) {
                answer = deq.peek();
            }
        }else if(str.equals("back")){
            if(!deq.isEmpty()) {
                answer = deq.peekLast();
            }
        }
        return answer;
    }
}
