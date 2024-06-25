import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1976 {

    /*
     * 특정 지점에서 출발 해서 다음 지점으로 갈 수 있는지 각각 찾아서 항상 true 면 go
     * 무한 루프 빼기 위해서 할때마다 v[] 갱신
     * 각각 뜯어서 하니 상관 없겠다
     * */

    static int n,m,answer;
    static boolean[] v;
    static ArrayDeque<Integer> plan = new ArrayDeque<>();
    static List<List<Integer>> g = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        v = new boolean[n+1];
        for(int i = 0 ; i<= n; i++){
            g.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < n; j++) {
                if(nums[j] == 1){
                    g.get(i+1).add(j+1);
                    g.get(j+1).add(i+1);
                }
            }
        }
        plan.addAll(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        boolean flag = true;
        int pre = plan.poll();
        while(!plan.isEmpty()){

            int now = plan.poll();
            if(!bfs(pre, now)){
                flag = false;
                break;
            }
            pre = now;
            v = new boolean[n+1];
        }

        writer.write(flag ? "YES" : "NO");
        writer.flush();
        writer.close();
    }

    static boolean bfs(int start, int end){
        if(start == end){
            return true;
        }
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        deq.add(start);

        while(!deq.isEmpty()){
            int pre = deq.poll();
            for(int now : g.get(pre)){
                if(v[now]){
                    continue;
                }
                v[now] = true;
                if(now == end){
                    return true;
                }
                deq.add(now);
            }
        }
        return false;
    }
}
