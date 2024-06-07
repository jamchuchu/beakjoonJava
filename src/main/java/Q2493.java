import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q2493 {

    static int n;
    static Deque<Tower> deq = new ArrayDeque<>();
    static PriorityQueue<Tower> beam = new PriorityQueue<>((o1, o2) ->
            o1.height - o2.height);
    static int[] answer;

    static class Tower{
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        answer = new int[n];
        String[] str = reader.readLine().split(" ");
        for(int i = 0; i < n ; i++){
            deq.addFirst(new Tower(i, Integer.parseInt(str[i])));
        }

        beam.add(deq.poll());

        while(!deq.isEmpty()){
            Tower t = deq.poll();
            while(beam.peek().height < t.height){// 해당 타워에 부딫치는것은 빼기
                Tower b = beam.poll();
                answer[b.idx] = t.idx+1;
                if(beam.isEmpty()){
                    break;
                }
            }
            beam.add(t);
        }

        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }

        writer.flush();
        writer.close();
    }


}
