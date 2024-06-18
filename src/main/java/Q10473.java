import java.io.*;
import java.util.*;

public class Q10473 {
    static class Edge{
        int to;
        double time;

        public Edge(int to, double time) {
            this.to = to;
            this.time = time;
        }
    }

    static int n = 0;
    static Double x, y, endX, endY;
    static List<List<Edge>> g = new ArrayList<>();
    static Double[] times;
    static Double[][] locations;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        x = Double.parseDouble(str[0]);
        y = Double.parseDouble(str[1]);

        str = reader.readLine().split(" ");
        endX = Double.parseDouble(str[0]);
        endY = Double.parseDouble(str[1]);

        n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i< n+2; i++){
            g.add(new ArrayList<>());
        }
        times = new Double[n+2];
        Arrays.fill(times, (double)10000000);
        locations = new Double[n+2][2];

        locations[0][0] = x;
        locations[0][1] = y;
        for(int i = 1; i<= n; i++){
            str = reader.readLine().split(" ");
            locations[i][0] = Double.parseDouble(str[0]);
            locations[i][1] = Double.parseDouble(str[1]);
        }
        locations[n+1][0] = endX;
        locations[n+1][1] = endY;


        for(int i = 0 ; i< n+2; i++){
            for(int j  = 0 ; j< n+2; j++){
                if(j == i)continue;
                double col = Math.abs(locations[i][0] - locations[j][0]);
                double row = Math.abs(locations[i][1] - locations[j][1]);
                double dist = Math.sqrt(Math.pow(col, 2) + Math.pow(row, 2));
                if(i == 0){//걸어서 출발
                    double time = dist / 5;
                    g.get(i).add(new Edge(j, time));
                    continue;
                }
                double walk = Math.abs(dist - 50);
                double time = Math.min((walk / 5) + 2, dist / 5);
                g.get(i).add(new Edge(j, time));
            }
        }

//        for(int i = 0 ; i< g.size(); i++){
//            for(int j  = 0 ; j< g.get(i).size(); j++){
//                System.out.print(g.get(i).get(j).time + " ");
//            }
//            System.out.println();
//        }

        dijk();

        writer.write(times[n+1]+" ");
        writer.flush();
        writer.close();
    }

    static void dijk(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.time));
        pq.add(new Edge(0,0));
        times[0] = (double) 0;

        while(!pq.isEmpty()){
            Edge pre = pq.poll();
            if(times[pre.to] < pre.time){
                continue;
            }
            for(Edge now : g.get(pre.to)){
                if(times[now.to] > times[pre.to] + now.time){
                    times[now.to] = times[pre.to] + now.time;
                    pq.add(new Edge(now.to, times[now.to]));
                }
            }
        }

    }
}
