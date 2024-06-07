import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q4374 {
    /*
    * n을 입력받고 단어의 개수가 일치하면 출력
    * map으로 단어 분석한다음 개수가 같은거 filter
    * 출력
\    * */

    static int n;
    static String reg = "[\\W_]+";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                n = Integer.parseInt(reader.readLine());
            }catch (Exception e){
                break;
            }
            List<String> words = new ArrayList<>();

            while(true){
                String str = reader.readLine(); // 한줄 씩 입력 받아서 쪼개고 넣기
                if(str.equals("EndOfText")){
                    break;
                }
                words.addAll(Arrays.stream(str.split(reg))
                                .filter(i -> i.length() > 1)
                                .filter(Predicate.not(String::isBlank))
                                .map(String::toLowerCase)
                                .collect(Collectors.toList()));
            }
            List<String> answers = words.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))// map생성
                    .entrySet().stream().filter(i -> i.getValue() == n)//개수 같은거만 filter
                    .map(Map.Entry::getKey)//키만 빼서
                    .sorted()
                    .collect(Collectors.toList());//정렬

            if(answers.size() > 0){
                answers.forEach(System.out::println);
            }else{
                System.out.println("There is no such word.");
            }
            System.out.println();
        }


    }

}
