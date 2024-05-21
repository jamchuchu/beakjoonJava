import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2179 {
    static int n;
    static String[] str;

    static class Answer{
        int count;
        List<String> strs;
        Answer(int count, List<String> strs){
            this.count = count;
            this.strs = strs;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        str = new String[n];
        Answer answer = new Answer(0,new ArrayList<>());
        //배열에 저장
        for(int i = 0; i < n; i++) {
            str[i] = reader.readLine();
        }

        for(int i = 0; i < n; i++) {
            List<String> pre = new ArrayList<>();
            // 나머지 후보군 추가
            for(String s: str){
                if(!s.equals(str[i])){
                    pre.add(s);
                }
            }
            //한글자씩 때서 확인 하기
            for(int j = 1; j <= str[i].length(); j++) {
                String s = str[i].substring(0,j);
                List<String> post = new ArrayList<String>();
                post = compare(pre, s);
                if(post.size() == 0 && pre.size() != n-1){
                    //count가 크면 저장
                    if(answer.count < i+1){
                        List<String> temp = new ArrayList<String>();
                        temp.add(pre.get(0));
                        temp.add(str[i]);
                        sort(temp);
                        answer.count = i+1;
                        answer.strs = temp;
                        break;
                    }
                }else if(post.size() == 0 && pre.size() == n-1){
                    break;
                }else{
                    pre = post;
                }
            }
        }
        System.out.println(answer.strs);
    }

    //들고온 문자열이 원래 다른 문자열들과 시작이 일치하는지
    //일치하면 다음에도 확인 하기 위해 새로운 배열에넣기
    static List<String> compare(List<String> pre, String str){
        List<String> post = new ArrayList<String>();
        for(String s : pre){
            if(s.length() < str.length()){
                continue;
            }
            if(s.substring(0, str.length()).equals(str)){
                post.add(s);
            }
        }
        return post;
    }

    //문자열 제공된 순서대로 정렬
    static void sort(List<String> list){
        List<String> temp = new ArrayList<String>(Arrays.asList(str));
        list.sort((o1, o2)->
                temp.indexOf(o1) - temp.indexOf(o2)
        );
    }
}
