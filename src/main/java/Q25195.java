import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q25195 {

    /*제대로 갔을때 종료 지점 찾고
    * 팬 만나면 return 종료 지점 다르면 yes
    * */
    static int n,m,s, answer;
    static List<List<Integer>> g = new ArrayList<>();
    static boolean[] go, v, fan;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        v = new boolean[n+1];
        fan = new boolean[n+1];
        go = new boolean[n+1];
        Arrays.fill(v, false);
        Arrays.fill(fan, false);
        Arrays.fill(go, false);
        for(int i = 0; i <= n; i++){
            g.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            str = reader.readLine().split(" ");
            g.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
            go[Integer.parseInt(str[0])] = true; // 앞으로 갈길 있나? 없으면 너가 마지막
        }


            s = Integer.parseInt(reader.readLine());
            Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(i -> fan[i] = true);

        if(go[1]){
            for(int i = 2; i <= n; i++){
                Arrays.fill(v, false);
                if(!go[i]){ // 뒤에서 출발
                    bfs(i);
                }
                if(v[1]){ //1에 도착하면
                    break;
                }
            }

            writer.write(v[1]? "yes" : "Yes");
        }else{
            writer.write(fan[1]? "Yes" :"yes");
        }


        writer.flush();
        writer.close();
    }


    static void bfs(int start){
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        deq.add(start);

        while(!deq.isEmpty()){
            int pre = deq.poll();
            if(fan[pre]){
                continue;
            }
            for(int now : g.get(pre)){
                if(fan[now]){
                    continue;
                }
                if(!v[now]){
                    deq.add(now);
                    v[now] = true;
                }
            }
        }
    }
}
