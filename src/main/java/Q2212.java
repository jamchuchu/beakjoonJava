import java.io.*;
import java.util.*;

public class Q2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        Set<Integer> sensors = new TreeSet<>();
        String[] str = reader.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            sensors.add(Integer.parseInt(str[i]));
        }
        PriorityQueue<Integer> dist = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int pre = 0;
        for(int s :  sensors){
            if(pre == 0){
                pre = s;
                continue;
            }
            dist.add(s - pre);
            pre = s;
        }

        for(int i = 0 ; i< k-1; i++){
            dist.poll();
        }

        int answer = 0;
        while(!dist.isEmpty()){
            answer += dist.poll();
        }
        System.out.println(answer);
    }
}
