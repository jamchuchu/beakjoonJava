import java.io.*;
import java.util.PriorityQueue;

public class Q2012 {

    /* pq 에 넣어서 peek */
    static int n;
    static long answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i<  n ; i ++){
            pq.add(Integer.parseInt(reader.readLine()));
        }

        for(int i = 0 ; i< n ; i++){
            answer += Math.abs((i+1) - pq.peek());
            pq.poll();
        }

        writer.write(answer+ " ");
        writer.flush();
        writer.close();
    }


}
