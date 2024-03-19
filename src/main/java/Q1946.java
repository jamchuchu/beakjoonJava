import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1946 {
    static int t,n;
    static int[][] group;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(reader.readLine());
        for(int i = 0; i< t; i++){
            n = Integer.parseInt(reader.readLine());
            group = new int[n][2];
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
                group[j][0] = Integer.parseInt(st.nextToken());
                group[j][1] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            Arrays.sort(group, (o1, o2) -> o1[0] - o2[0]);// 높은 순위로 정렬

            int border = group[0][1];

            for(int j = 1 ; j < n; j++){
                if(group[j][1] > border){
                    count++;
                    continue;
                }
                border = group[j][1];
            }
            System.out.println(n-count);
        }
    }
}
