import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2568A {
    static int n;
    static int[][] list;
    static List<List<Integer>> g = new ArrayList<List<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        list = new int[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            g.add(new ArrayList<>());
        }
        Arrays.sort(list, (o1, o2) -> o1[0] - o2[0]);
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list[i][2] = searchConnect(i, list[i]);
            list[i][3] = i;
        }
        Arrays.sort(list, (o1, o2) -> o2[2] - o1[2]);
        for(int i = 0; i< n; i++){
            System.out.println(list[i][3] + " " +  list[i][2]);
        }

        while(list[0][2] != 0) {
            int index = list[0][3];
            //삭제
            answer.add(list[0][0]);
            list[0][0] = 0;
            list[0][2] = 0;

            for (int num : g.get(index)) {
                if(list[num][0] == 0){
                    continue;
                }
                System.out.print(num + " ");
                if(list[num][2] == 0){
                    continue;
                }
                list[num][2]--;
            }
            System.out.println();
            Arrays.sort(list, (o1, o2) -> o2[2] - o1[2]);
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        answer.forEach(i -> System.out.println(i));
    }

    static int searchConnect(int index, int[] now){
        int count = 0;
        for(int i = 0; i < n ; i++){
            if(i == index){
                continue;
            }
            if(list[i][1] == 0){
                continue;
            }
            int A  = now[0] - list[i][0];
            int B = now[1] - list[i][1];

            int C = A * B;
            if(C < 0){
                // 접점들 저장
                g.get(index).add(i);
                 count++;
            }
        }
        return count;
    }

}
