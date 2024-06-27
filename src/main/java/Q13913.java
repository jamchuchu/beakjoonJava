import java.io.*;
import java.util.*;

public class Q13913 {
    static int n,k;
    static final int max = 100000;
    static int[] dx = {1,-1, 2};
    static int[] dp;
    static ArrayDeque<Integer> list = new ArrayDeque<>();
    static List<List<Integer>> g = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        dp = new int[max+1];
        for(int i = 0; i<= max; i++){
            g.add(new ArrayList<>());
        }
        Arrays.fill(dp, max);

        bfs(n);
        writer.write(dp[k]+"\n");

        int idx = k;
        int num = dp[k];
        list.add(idx);
        while(true){
            if(num == 0){
                break;
            }
            num--;

            if(idx -1 >= 0  && num == dp[idx-1]){
                idx = idx-1;
                list.addFirst(idx);
                continue;
            }
            if(idx +1 <= max && num == dp[idx+1]){
                idx = idx+1;
                list.addFirst(idx);
                continue;
            }
            if(idx % 2 == 0 && num == dp[idx/2]){
                idx = idx/2;
                list.addFirst(idx);
            }
        }

        for(int i: list) {
            writer.write(i + " ");
        }
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        dp[start] = 0;
        que.add(start);

        while(!que.isEmpty()){
            int preIdx = que.poll();
            for(int i = 0; i< 2; i++){
                int nowIdx = preIdx + dx[i];
                if(nowIdx < 0 ||nowIdx > max){
                    continue;
                }
                if(dp[nowIdx] > dp[preIdx] + 1){
                    dp[nowIdx] = dp[preIdx] + 1;
                    que.add(nowIdx);
                    g.get(preIdx).add(nowIdx);
                }
            }
            int nowIdx = preIdx * dx[2];
            if(nowIdx > max){
                continue;
            }
            if(dp[nowIdx] > dp[preIdx] + 1){
                dp[nowIdx] = dp[preIdx] + 1;
                que.add(nowIdx);
                g.get(preIdx).add(nowIdx);
            }
        }
    }



}
