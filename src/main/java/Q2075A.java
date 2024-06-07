import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q2075A {
    /*
    * pq 쓰면? 별로 안걸릴듯? 1500**2 = 7500000 1억 안됨
    *
    * 	339672	1084
    *
    * */

    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0; i< n ; i++){
            pq.addAll(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
        for(int i = 0; i< n-1; i++){
            pq.poll();
        }
        writer.write(String.valueOf(pq.poll()));

        writer.flush();
        writer.close();
    }


}
