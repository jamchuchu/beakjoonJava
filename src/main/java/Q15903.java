import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q15903 {
    /*
    * 큰순서대로 정렬
    * 하나씩 빼면서 곱셈
    *
    * 15496	180
    *
    * */

    static int n, m;
    static long answer;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        pq.addAll(Arrays.stream(reader.readLine().split(" "))
                .map(Long::parseLong).collect(Collectors.toList()));

        int i = 0;
        while(i < m){
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a +b);
            pq.add(a +b);
            i++;
        }

        while(!pq.isEmpty()){
            answer += pq.poll();
        }

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
    }

}
