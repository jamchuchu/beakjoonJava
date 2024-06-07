import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* 입력받은후 .단위로 잘라서
* map에 숫자를 올리면서 넣는다
*/
public class Q20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SortedMap<String, Integer> answer = new TreeMap<>();


        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ;i++){
            String[] name = reader.readLine().split("\\.");
            int preCount = 0;
            if(answer.containsKey(name[1])) {
                preCount = answer.get(name[1]);
            }
            answer.put(name[1], preCount+1);
        }

        for(Map.Entry<String, Integer> ans : answer.entrySet()){
            System.out.println(ans.getKey() + " " + ans.getValue());
        }

    }
}
