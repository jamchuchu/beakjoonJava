import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q2568 {
    static int n;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
            Math.abs(o2[1] - o2[0]) - Math.abs(o1[1] - o1[0]));
    static int[][] list;
    static List<Integer> answer = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        list = new int[500001][2];
        for(int i = 0 ; i< n ; i++){
            StringTokenizer st= new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b});
            list[a] = new int[]{a,b};
        }

        check();

        System.out.println(answer.size());
        answer.forEach(i -> System.out.println(i));
    }

    // 하나씩 지워가면서 test
    static void check(){
        System.out.println();
        int pre0 = 0;
        int pre1 = 0;
        for(int i = 1 ; i< list.length; i++){
            if(list[i][0] == 0){
                continue;
            }
            if(list[i][1] - pre1 < 0){
                answer.add(pre0);
                continue;
           }
            pre0 = list[i][0];
            pre1 = list[i][1];
            String[] test = new String[5];

            String str = Arrays.asList(test).stream().collect(Collectors.joining());
            String temp = Arrays.asList(test).stream().collect(Collectors.joining());
        }
    }

}
