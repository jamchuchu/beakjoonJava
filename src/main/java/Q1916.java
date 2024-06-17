import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q1916 {

    /*
    * 84860	932
    *
    * */
    static class Edge{
        int to;
        int money;

        public Edge(int to, int money) {
            this.to = to;
            this.money = money;
        }
    }

    static int answer, n,m;
    static int[] money;
    static List<List<Edge>> buses = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        money = new int[n+1];
        Arrays.fill(money, Integer.MAX_VALUE);
        for(int i = 0 ; i < n+1 ; i++){
            buses.add(new ArrayList<>());
        }
        for(int i = 0 ; i< m; i++){
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            buses.get(nums[0]).add(new Edge(nums[1] , nums[2]));
        }

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dijk(nums[0]);

        writer.write(money[nums[1]] + " ");
        writer.flush();
        writer.close();
    }

    static void dijk(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.money - o2.money);
        money[start] = 0;
        pq.add(new Edge(start, 0));


        while(!pq.isEmpty()){
            Edge pre = pq.poll();
            if(money[pre.to] < pre.money){
                continue;
            }
            for(Edge now: buses.get(pre.to)){
                if(money[now.to] > money[pre.to] + now.money){
                    money[now.to] = money[pre.to] + now.money;
                    pq.add(new Edge(now.to , money[now.to]));
                }
            }
        }
    }
}
