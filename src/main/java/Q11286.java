import java.io.*;
import java.util.PriorityQueue;

public class Q11286 {
    /*
    * 절댓값 기준, 크기 기준으로 pq
    *
    *
    * 	26088	380
    * */

    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{
        if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
        return Math.abs(o1) - Math.abs(o2);
    });
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(reader.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    writer.write(0 + "\n");
                    continue;
                }
                writer.write(pq.poll() + "\n");
                continue;
            }
            pq.add(num);
        }

        writer.flush();
        writer.close();
    }


}
