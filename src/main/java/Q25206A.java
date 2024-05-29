import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25206A {
    /*
    * 각 인정 학점(count)와 score를 입력받는다
    * score에 따라 점수로 환산하고 학점과 곱해서 totalScore로 더한다
    * P는 위 과정 continue
    * 인정학점의 totalcount를 더한다
    * totalScore/ totalCount 한다음 6자리 반올림 한다 //반올림 방식 기억하기!
    */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = 0;
        float totalScore = 0;
        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            st.nextToken();
            int count = (int)Float.parseFloat(st.nextToken());
            String score = st.nextToken();
            if(!score.equals("P")){
                totalScore += checkScore(score) * count;
                totalCount += count;
            }

        }
        String answer = String.format("%.6f",totalScore/totalCount);
        System.out.println(answer);
    }

    static float checkScore(String str){
        if(str.equals("A+")){
            return 4.5F;
        }else if(str.equals("A0")){
            return 4.0F;
        }else if(str.equals("B+")){
            return 3.5F;
        }else if(str.equals("B0")){
            return 3.0F;
        }else if(str.equals("C+")){
            return 2.5F;
        }else if(str.equals("C0")){
            return 2.0F;
        }else if(str.equals("D+")){
            return 1.5F;
        }else if(str.equals("D0")){
            return 1.0F;
        }
        return 0;
    }
}
