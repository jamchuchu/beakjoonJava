import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2179A {
    static int count;
    static int n;
    static List<String> list = new ArrayList<>();
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            list.add(reader.readLine());
        }

        for(int i = 0; i < n; i++) {
            String target = list.get(i);
            List<String> candi = new ArrayList<>(list);
            candi.remove(target);

            // 한글자씩 떼서 비교
            List<String> pre = new ArrayList<>();

            for(int j = 1; j <= target.length(); j++){
                String smallTarget = target.substring(0,j);//n
                List<String> post = new ArrayList<>();
                post.add(target);
                // 같은 것 확인, 추출
                for(String s: candi){
                    if(compare(s, smallTarget)){
                        post.add(s);
                    }
                }
                if(post.size() == 1 && pre.size() == 0){
                    break;
                }
                if(post.size() == 1 && pre.size() != 0){
                    if(count <= j-1) {
                        count = j-1;
                        answer = new ArrayList<>(pre);
                        break;
                    }
                }
                pre = new ArrayList<>(post);
            }
        }


        answer.sort((o1, o2) ->
                list.indexOf(o1) - list.indexOf(o2)
                );
        System.out.println(answer.get(0));
        System.out.println(answer.get(1));
    }

    static boolean compare(String s, String smallTarget){
        if(s.length() < smallTarget.length()){
            return false;
        }
        if(s.substring(0, smallTarget.length()).equals(smallTarget)){
            return true;
        }
        return false;
    }

}
