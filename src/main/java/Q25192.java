import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q25192 {
    /*
    * enter를 기준으로 새 map을 파서
    * 안에 있으면 count x
    * 없으면 count 0
    * contain 대신 size 사용 판별!
    * 25320	288
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        int size = 0;
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            String s = reader.readLine();
            if(s.equals("ENTER")){
                size = 0;
                set.clear();
                continue;
            }
            set.add(s);
            if(size != set.size()){
                size = set.size();
                count++;
            }
        }

        System.out.println(count);
    }
}
