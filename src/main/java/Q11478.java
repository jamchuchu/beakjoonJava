import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
* 글자수 대로 쪼개는 것은 substring 사용 하면 될듯 했고
* 쪼개는 숫자는 dfs로 정의하면 되겠다고 생각했다
* */
public class Q11478 {
    static String str;
    static Set<String> set = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
        dfs(0,0, new int[2]);
        System.out.println(set.size());
    }
    static void dfs(int depth, int num, int[] list){
        if(depth == 2){
            set.add(str.substring(list[0] , list[1]));
            return;
        }
        for(int i = num; i <= str.length(); i++){
            list[depth] = i;
            dfs(depth +1, i+1, list);
        }
    }
}
