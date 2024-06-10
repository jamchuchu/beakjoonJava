import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q19638 {


    static int answer, n, h, t;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2 -o1);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(reader.readLine()));
        }

        for(int i = 0 ; i < t; i++){

            if(pq.peek() != 1) {
                int height = pq.poll() / 2;
                pq.add(height);
            }


            if(pq.peek() < h){
                System.out.println(i);
                answer = i + 1 ;
                break;
            }
            System.out.println(pq);
        }

        writer.write(pq.peek() < h ? "YES" + "\n" +  answer : "NO"  + "\n" + pq.peek() );
        writer.flush();
        writer.close();
    }


}
