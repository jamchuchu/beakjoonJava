import java.util.*;
import java.util.stream.Collectors;

public class Q1764A {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.stream().map(Integer::parseInt).collect(Collectors.toList());


        Set<String> names = new TreeSet<>();

        Map<String, Integer> map = new HashMap<>();
        map.put("1" , 1);
        map.put("3" , 3);
        map.put("4" , 4);
        map.put("2" , 2);

//        Collections.sort(map);


        Map<String, Integer> map2 = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(i -> (i.getKey()), i->(i.getValue())));
        System.out.println(map2);

//        words.stream().mapToInt().

//         Map<String, Integer> AllAris = new HashMap<>();
//        words.stream().collect(Collectors.toMap(Function.identity(), Collectors.groupingBy( )))
//        Arrays.stream(words.stream().map(String::toString).
    }
}
