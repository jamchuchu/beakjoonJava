import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q1213 {
    /*
    * 글자의 홀짝 판단
    * 전체 홀 - 홀 1개
    * 전체 짝 -홀 0 개
    * 사전순으로 글자 정렬 후 하나씩 복사
    * 역방향 복사
    *
    * 18240	200
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();

         List<Map.Entry<String, Long>> map = Arrays.stream(str.split("")).collect(Collectors.toList())
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))//map 작성
                 .entrySet().stream().sorted(Map.Entry.comparingByKey())//순저대로 정렬
                 .collect(Collectors.toList());//list

         List<Map.Entry<String, Long>> oddNumList
                 = map.stream().filter(i ->  i.getValue() % 2 == 1)
                 .collect(Collectors.toList());

        System.out.println(makeAnswer(n, oddNumList, map));


    }

    static String makeAnswer(int length, List<Map.Entry<String, Long>> oddNumList, List<Map.Entry<String, Long>> map){
        String answer = "";
        Deque<String> answerRe = new LinkedList<>();

        if(!checkCanMakeAnswer(length, oddNumList)){
            answer = "I'm Sorry Hansoo";
            return answer;
        }

        //홀수 인 것만 넘기고 짝수인것은 value 값 /2 대로 출력
        for(Map.Entry<String, Long> entry : map){
            if(entry.getValue() == 1) {
                continue;
            }else if(entry.getValue() % 2 == 1){
                for(int i = 0 ; i < (entry.getValue()-1) / 2; i++){
                    answer += entry.getKey();
                    answerRe.addFirst(entry.getKey());
                }
            }else{
                for(int i = 0 ; i < entry.getValue() / 2; i++){
                    answer += entry.getKey();
                    answerRe.addFirst(entry.getKey());
                }
            }
        }
        if(length % 2 == 1) {
            answer += oddNumList.get(0).getKey();
        }
        answer += answerRe.stream().collect(Collectors.joining());

        return answer;
    }

    static boolean checkCanMakeAnswer(int length, List<Map.Entry<String, Long>> oddNumList){
        int oddNum = oddNumList.size();
        if(length % 2 == 0 && oddNum != 0){
            return false;
        }else if(length % 2 == 1 && oddNum != 1){
            return false;
        }
        return true;
    }
}
