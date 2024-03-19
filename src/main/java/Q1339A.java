import java.util.*;
public class Q1339A {
    static int n;
    static Map<String, Integer> map  =  new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            Deque<String> deq = new LinkedList<>(Arrays.asList(sc.nextLine().split("")));
            int size = 0;
            while(!deq.isEmpty()) {
                String s = deq.pollLast();
                if(s.isBlank()){
                    continue;
                }
                if(!map.containsKey(s)){
                    map.put(s, (int) Math.pow(10, size));
                }else{
                    int value = map.get(s);
                    map.put(s, value + (int) Math.pow(10 ,size));
                }
                size++;
            }
        }

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, (o1, o2) -> o2 - o1);
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            deq.add(9 - i);
        }

        int answer = 0;
        for(int num : values){
            answer += num * deq.poll();
        }

        System.out.println(answer);
//        System.out.println(map);
    }
}
