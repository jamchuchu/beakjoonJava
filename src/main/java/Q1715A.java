import java.io.*;
import java.util.PriorityQueue;

public class Q1715A {
    /*
    * 작은거 2개 빼서 합을 넣음
    *
    *
    * 25640	412
    *
    * */

    static int n, answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i < n ; i++) {
            pq.add(Integer.parseInt(reader.readLine()));
        }


        while(pq.size() != 1){
            int a = pq.poll();
            int b = pq.poll();
            answer += a + b;
            pq.add(a + b);
        }

        writer.write(answer + " ");

        writer.flush();
        writer.close();
    }


}
