import java.io.*;
import java.util.*;

public class Q1325A {
    static int n, m, answer, max;
    static List<List<Integer>> g = new ArrayList<>();
    static boolean[] v;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str= reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        for(int i= 0 ; i<= n; i++){
            g.add(new ArrayList<>());
        }

        numbers = new int[n+1];
        v = new boolean[n+1];


        for(int i = 0 ; i< m; i++){
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            g.get(b).add(a);
        }

//        System.out.println(g);

//        for(int i = 1 ; i<= n; i++){
//                System.out.print(numbers[i] + " ");
//        }
//        System.out.println();

        //1 다 해보기
        max = 0;
        for(int i = 1 ; i<= n; i++){
            v = new boolean[n+1];
            bfs1(i);
            for(int j = 1 ; j<= n; j++){
                if(v[j]){
                    numbers[i]++;
                }
            }
            max = Math.max(max, numbers[i]);
        }

        for(int i = 1 ; i<= n; i++){
            if(numbers[i] == max){
                writer.write(i + " ");
            }
        }

        writer.flush();
        writer.close();
    }

    //아마 카운트 하면 타임 오버
    //해당 리스트 들고 다니면서 한꺼번에 ..?
    /*
    * 보다는 dp 처럼 정점 n -> 정점 -1 = n-1 이렇게 하고 싶긴한데..
    * 위상정렬 식이 좋을지도?
    *
    * 아니면 dfs 풀이도 있을 것 같고
    *
    * bfs 가 제일 별로인데.. ㄴ
    * 그럼 leaf 부터 하나씩 1씩 올려가면서 역방향으로 받는게 맞지 않나? -- 회전 있어서 실패
    *
    * leaf 은 어떻게 알수 있는가? --? 더이상 꼬리가 없는것 한번에 ㄱㄱ -- 회전 있어서 실패
    *
    * */


    static void bfs1(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        v[start]  = true;


        while(!que.isEmpty()){
            int pre = que.poll();
            for(int now: g.get(pre)){
                if(v[now]){
                    continue;
                }
                v[now] = true;
                que.add(now);
            }
        }
    }
}
