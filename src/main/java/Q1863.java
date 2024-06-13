import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q1863 {


    static int n, answer;
    static ArrayDeque<int[]> deq = new ArrayDeque<>();
    static ArrayDeque<Integer> candis = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());

        for(int i = 0 ; i < n ; i++) {
            deq.add(Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        deq = new ArrayDeque<>(deq.stream().sorted((o1, o2) -> o1[0] - o2[0]).collect(Collectors.toList()));
//        if(deq.peekFirst()[1] == 0){
//            deq.pollFirst();
//        }

        int count = 0;

        while(!deq.isEmpty()) {
            int[] now = deq.pollLast();

            if(candis.isEmpty()){
                candis.addFirst(now[1]);
                continue;
            }
            if(candis.peekFirst() < now[1]){
                candis.addFirst(now[1]);
                continue;
            }
            if(candis.peekFirst() > now[1]){

                while(true){
                    if(candis.isEmpty() && now[1] == 0){
                        break;
                    }
                    if(candis.isEmpty()){
                        candis.addFirst(now[1]);
                        break;
                    }
                    if(candis.peekFirst() == now[1]){
                        break;
                    }
                    if(candis.peekFirst() < now[1]){
                        candis.addFirst(now[1]);
                        break;
                    }
                    candis.pollFirst();
                    count++;

                }
            }

        }

        writer.write(count + candis.size() + " ");
        writer.flush();
        writer.close();
    }
}
