import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1325 {

    static List[] coms;
    static List<Integer> arr;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        coms = new ArrayList[N+1];

        for (int i =0; i< N+1; i++){
            coms[i] = new ArrayList<Integer>();
        }


//        int[][] coms = new int[N+1][N+1];
        int[] dp = new int[N + 1];

        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split(" ");
            coms[Integer.parseInt(str[1])].add(Integer.parseInt(str[0]));
//            dp[Integer.parseInt(str[1])] += 1;
        }

//        for (int i = 0; i < N+1; i++) {
//            System.out.print(coms[i]);
//        }


        arr = new ArrayList<>();
//
//        for (int i = 0; i < N+1; i++) {
//            arrIdx(coms[i], i);
//        }
//
//        arr.forEach(j -> {
//            System.out.print(j);
//        });
//        System.out.println();

        for (int i = 0; i < N+1; i++) {
            System.out.print(coms[i]);
        }


        for (int i = 0; i < N+1; i++) {
            final int index = i;
            coms[index].forEach(j -> dp[index] += dp[(int) j]);
        }

        int max = 0;
        List<Integer> maxIdx = new ArrayList<>();

        for(int i = 1; i < N+1; i++) {
            if(dp[i] > max){
                maxIdx.clear();
                maxIdx.add(i);
                max = dp[i];
            }else if(dp[i] == max){
                maxIdx.add(i);
            }
        }

        Collections.sort(maxIdx);
        maxIdx.forEach(i -> {
            System.out.print(i + " ");
        });

//
//        for (int i = 0; i < N+1; i++) {
//            System.out.print(dp[i]);
//        }
    }

    static void arrIdx(List com, int idx){
        if(com.size() == 0){
            arr.add(idx);
            return;
        }
        com.forEach(i -> {
            arrIdx(coms[(int)i], (int)i);
        });
    }
}
