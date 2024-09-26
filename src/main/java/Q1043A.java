import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q1043A {
    static int answer, n, m, knowPersonNum;
    static boolean[] knowPerson;
    static List<List<Integer>> g = new ArrayList<>();
    static List<List<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        knowPerson = new boolean[n + 1];

        str = reader.readLine().split(" ");
        knowPersonNum = Integer.parseInt(str[0]);
        for (int i = 0; i < knowPersonNum; i++) {
            knowPerson[Integer.parseInt(str[i + 1])] = true;
        }


        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            str = reader.readLine().split(" ");
            int partyNum = Integer.parseInt(str[0]);
            int[] temp = new int[partyNum];
            parties.add(new ArrayList<>());
            for (int j = 0; j < partyNum; j++) {
                temp[j] = Integer.parseInt(str[j + 1]);
                parties.get(i).add(temp[j]);
            }
            for (int j = 0; j < partyNum; j++) {
                for (int k = j + 1; k < partyNum; k++) {
                    g.get(temp[j]).add(temp[k]);
                    g.get(temp[k]).add(temp[j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(knowPerson[i]){
                bfs(i);
            }
        }


//        for(int i = 0 ; i <= n; i++){
//            System.out.print(knowPerson[i] + " ");
//        }
//        System.out.println();

        for(int i = 0 ; i <m ; i++){
            boolean flag = false;

            for(int num : parties.get(i)){
                if(knowPerson[num]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer++;
            }
        }


        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }

    static void bfs(int start){
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(start);

        while(!que.isEmpty()) {
            int pre = que.poll();
            for(int now : g.get(pre)){
                if(!knowPerson[now]){
                    knowPerson[now] = true;
                    que.add(now);
                }
            }
        }
    }
}

