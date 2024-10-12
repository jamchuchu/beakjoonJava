import java.io.*;
import java.util.ArrayList;
import java.util.List;


/*
* 그래프로 넣는다
*
* 목표치를 위해 지어야 할것을 dfs로 찾는다
* 그것을 위해 찾고, 또 찾는다
* 없으면 그것 부터 짓는다
*
* bfs 로 시간 더해가면서 하는데
* 하기전에 boolean[] build 로 필요한 것들이 다 지어졌는지 확인한다
*
* 각 필요한 것의 누적시간을 구한다
* 두개이상 일때는 max + buildTime 이다
*
*
* */

public class Q1005A {

    static int T, n, k, w;
    static int[] buildTime;
    static int[] totalBuildTime;
    static boolean[] isBuild;
    static List<List<Integer>> to = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(reader.readLine());

        for(int t = 0 ; t< T; t++){
            String[] str = reader.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            k = Integer.parseInt(str[1]);

            buildTime = new int[n + 1];
            totalBuildTime = new int[n + 1];
            isBuild = new boolean[n + 1];
            str = reader.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                buildTime[i] = Integer.parseInt(str[i - 1]);
            }

            to = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                to.add(new ArrayList<>());
            }

            for (int i = 0; i < k; i++) {
                str = reader.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                to.get(b).add(a);
            }

            w = Integer.parseInt(reader.readLine());

            dfs(w);

            writer.write(totalBuildTime[w] + "\n");
        }
        writer.flush();
        writer.close();
    }

    static void dfs(int idx){ // 4번집
        if(to.get(idx).isEmpty()){//4번을 위해 더 지을게 없으면
            totalBuildTime[idx] = buildTime[idx]; // total  == 짓는시간
            return;
        }

        if(isBuild[idx]){
            return;
        }
        isBuild[idx] = true;

        for(int i : to.get(idx)){ // i = 2,3
            dfs(i); // 2,3
            totalBuildTime[idx] = Math.max(totalBuildTime[idx], buildTime[idx] + totalBuildTime[i]);
        }
    }


}
