import java.io.*;
import java.util.*;

public class Q1374 {
    static class Lec{
        int idx, start, end;

        public Lec(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }
    }

    static int answer, n;
    static PriorityQueue<Lec> pq = new PriorityQueue<>((o1, o2) ->  o1.end - o2.end);
    static Queue<Lec> lec = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        List<Lec> temp = new ArrayList<>();
        for(int i = 0 ; i< n; i++){
            String[] str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            temp.add(new Lec(a,b,c));
        }

        temp.sort((o1, o2) ->  o1.start - o2.start);
        lec.addAll(temp);

        while(!lec.isEmpty()){
            Lec now = lec.poll();
            if(pq.isEmpty()){
                pq.add(now);
                answer =Math.max(answer, pq.size());
                continue;
            }
            //제일 빨리 끝나는 것보다 지금 시작시간이 같거나 크면
            if(pq.peek().end <= now.start){
                pq.poll();
            }
            pq.add(now);
            answer =Math.max(answer, pq.size());
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
