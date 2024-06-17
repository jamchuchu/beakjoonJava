import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q10282 {
    /*
    *	180136	972
    * */
    static class Edge{
        int to, time;
        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
    static int k,n,m,s,answer, answerTime;
    static List<List<Edge>> list = new ArrayList<>();
    static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(reader.readLine());
        for(int l = 0; l < k ; l++){
            String[] str = reader.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            s = Integer.parseInt(str[2]);
            list = new ArrayList<>();
            answer = 0;
            answerTime = 0;
            for(int i = 0; i <= n; i++){
                list.add(new ArrayList<>());
            }
            times = new int[n+1];
            Arrays.fill(times, Integer.MAX_VALUE);

            for(int i = 0 ; i < m; i++){
                str = reader.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                int c = Integer.parseInt(str[2]);
                list.get(b).add(new Edge(a,c));
            }

            dijk(s);

            for(int i = 1 ; i<= n; i++){
                if(times[i] != Integer.MAX_VALUE){
                    answer++;
                    answerTime = Math.max(answerTime, times[i]);
                }
            }
            writer.write(answer + " " + answerTime +"\n");
        }

        writer.flush();
        writer.close();
    }
    static void dijk(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        pq.add(new Edge(start, 0));
        times[start] = 0;

        while(!pq.isEmpty()){
            Edge pre = pq.poll();
            if(times[pre.to] < pre.time){
                continue;
            }
            for(Edge now : list.get(pre.to)){
                if(times[now.to] > times[pre.to] + now.time){
                    times[now.to] = times[pre.to] + now.time;
                    pq.add(new Edge(now.to, times[now.to]));
                }
            }
        }
    }

}
