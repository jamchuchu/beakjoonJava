import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*입력받은 다음 max 값을 구하고
* 문제가 시킨대로 나누고 곱해준다
* float로 캐스팅만 하면된다!*/
public class Q1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        int max = 0;
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            list[i] =Integer.parseInt(st.nextToken());
            max = Math.max(max, list[i]);
        }

        float answer = 0;
        for(int i = 0; i < n; i++){
            //answer = ((float) (list[i] /max) * 100);
            float a = (float) list[i] /max * 100;
            answer += a;
        }
        System.out.println(answer/n);


    }
}
