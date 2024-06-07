import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력받은대로 map에 넣어준다
* value가 true이면 입력
*
* 트리맵정의시 람다 쓰지 않고 comparator 사용
* map 들고 올때 entryset 사용
* */
public class Q7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SortedMap<String, Boolean> log = new TreeMap<>(Comparator.reverseOrder());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            String name = st.nextToken();
            String type = st.nextToken();
            log.put(name, enterOrLeave(type));
        }

        for(Map.Entry<String , Boolean> l: log.entrySet()){
            if(l.getValue()){
                System.out.println(l.getKey());
            }
        }
    }

    static boolean enterOrLeave(String str){
        if(str.equals("enter")){
            return true;
        }else{
            return false;
        }
    }
}
