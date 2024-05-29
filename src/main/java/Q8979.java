import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8979 {
    /*
     * 입력받아 금, 은, 동 메달로 정렬
     * 동률일때 랭킹이 오르면 안되니 위와 비교해서 같으면 그대로 등수들고오고 다르면 i+1
     * 다시 for 돌리면서 국가 번호 같으면 등수 return
     */
    static int n, k;
    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new int[n][5];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < 4; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(list, (o1, o2)->{
            if(o2[1] == o1[1]) { // 금메달 수가 같다면
                if(o2[2] == o1[2]) { // 은메달 수가 같다면
                    return o2[3] - o1[3]; // 동메달 수로 정렬
                }
                return o2[2] - o1[2]; // 은메달 수로 정렬
            }
            return o2[1] - o1[1]; // 금메달 수로 정렬
        });


        int answer = 1;
        for(int i = 1; i< n; i++){
            if(list[i][1] != list[i-1][1] || list[i][2] != list[i-1][2]|| list[i][3] != list[i-1][3]){
                list[i][4] = i+1;
            }else{
                list[i][4] = list[i-1][4];
            }
            if(list[i][0] == k){
                answer = list[i][4];
            }
        }
        System.out.println(answer);
    }
}
