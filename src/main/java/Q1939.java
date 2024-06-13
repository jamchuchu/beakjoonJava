import java.io.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1939 {
    static class Bridge{
        int to;
        BigInteger weight;

        public Bridge(int end, BigInteger weight) {
            this.to = end;
            this.weight = weight;
        }
    }

    static List<List<Bridge>> g =new ArrayList<>();
    static int n,m;
    static BigInteger[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        for(int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        answer = new BigInteger[n+1];


        BigInteger maxWeight = BigInteger.ZERO;
        for(int i = 0; i < m; i++) {
            str = reader.readLine().split(" ");
            g.get(Integer.parseInt(str[0])).add(new Bridge(Integer.parseInt(str[1]), new BigInteger(str[2])));
            g.get(Integer.parseInt(str[1])).add(new Bridge(Integer.parseInt(str[0]), new BigInteger(str[2])));
            maxWeight = maxWeight.add(new BigInteger(str[2]));
        }

        Arrays.fill(answer, maxWeight);

        str = reader.readLine().split(" ");
        bfs(Integer.parseInt(str[0]));
//
//        for(int i = 1 ; i <= n ; i++){
//            System.out.print(answer[i] + " ");
//        }
//        System.out.println();

        writer.write(answer[Integer.parseInt(str[1])] + " ");
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        ArrayDeque<Bridge> deq = new ArrayDeque<>();
        deq.add(new Bridge(start , BigInteger.ZERO));
        answer[start] = BigInteger.ZERO;

        while (!deq.isEmpty()){
            Bridge pre = deq.poll();//출발
            for(Bridge now : g.get(pre.to)){
//                if(answer[now.to] < now.weight){
//                    continue;
//                }
                if(answer[now.to].compareTo(answer[pre.to].add(now.weight)) == 1){
                    answer[now.to] = answer[pre.to].add(now.weight);
                    deq.add(now);
                }
            }
        }
    }
}
