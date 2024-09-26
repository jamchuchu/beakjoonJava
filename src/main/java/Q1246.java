import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1246 {
    static int answer, price, n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        PriorityQueue<Integer> list = new PriorityQueue<>(m, Comparator.reverseOrder());
        for(int i = 0; i < m; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }

        int idx = 1;
        while(!list.isEmpty()){
            int now = list.poll();
            answer = Math.max(answer, now * idx);
            if(answer == now * idx){
                price = now;
            }
            if(n == idx)break;
            idx++;
        }

        writer.write(price+" " + answer);
        writer.flush();
        writer.close();
    }

}
