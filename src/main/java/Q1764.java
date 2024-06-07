import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1764 {
    /*
    * 중복되는 사람 이름 찾기인데
    * 이중 for문이나 contain 돌리는 것보다
    * 다 넣어서 distint하는게 좋을것 같다 -> 결국 두번 일하는 것
    *
    * 29020	444
    *
    * 질문?? map to int와 Integer::parseInt 의 차이
    *
    *
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sum(); // 숫자 합 구하기

        Map<String, Integer> map = new HashMap<>(); // 입력
        for(int i = 0; i< num; i++){
            String key = reader.readLine();
            int count = map.get(key) == null ? 0 : map.get(key);
            map.put(key, count + 1);
        }


        List<String> answer =  map.entrySet().stream().filter(i ->  i.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted().collect(Collectors.toList());

        System.out.println(answer.size());
        answer.forEach(i -> System.out.println(i));






    }
}
