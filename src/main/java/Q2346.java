import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q2346 {
    static int n;
    static ArrayDeque<Balloon> deq = new ArrayDeque<>();

    static class Balloon{
        int idx;
        int num;
        Balloon(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        int[] temp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i< n; i++){
            deq.add(new Balloon(i+1, temp[i]));
        }

        while(true){
            Balloon now = deq.poll();
            writer.write(now.idx + " ");
            if(deq.isEmpty()){
                break;
            }
            if(now.num > 0){
                for(int i = 0; i < now.num-1; i++){
                    deq.add(deq.poll());
                }
            }else{
                for(int i = 0; i < Math.abs(now.num); i++){
                    deq.addFirst(deq.pollLast());
                }
            }
        }

        writer.flush();
        writer.close();
    }
}
