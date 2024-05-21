import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2179B {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] list = new String[n];
        String answer1 = "";
        String answer2 = "";
        int count = -1;
        for(int i = 0; i < n; i++) {
            list[i] = reader.readLine();
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                String s1 = list[i];
                String s2 = list[j];
                for(int k = 0; k < Math.min(s1.length(), s2.length()); k++) {
                    if(s1.charAt(k) != s2.charAt(k)){
                        break;
                    }else{
                        if(count < k){
                            answer1 = s1;
                            answer2 = s2;
                            count = k;
                        }
                    }
                }
            }
        }
        System.out.println(answer1);
        System.out.println(answer2);

    }
}
