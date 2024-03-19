import java.util.*;

public class Q1339 {
    static List<Num> pq;
    static class Num{
        String s;
        int score;
        Num(String s, int score) {
            this.s = s;
            this.score = score;
        }
        boolean equalsS(String str){
            if(s.equals(str)){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        pq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Deque<String> deq = new LinkedList<>(Arrays.asList(sc.nextLine().split("")));
            int size = 0;
            while (!deq.isEmpty()) {
                String s = deq.pollLast();
                if (s.isBlank()) {
                    continue;
                }
                if (!containS(s)) {
                    pq.add(new Num(s, (int) Math.pow(10, size)));
                } else {
                    for (Num num : pq) {
                        if (num.equalsS(s)) {
                            num.score += (int) Math.pow(10, size);
                        }
                    }
                }
                size++;
            }
        }

        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            deq.add(9 - i);
        }

        Collections.sort(pq, (o1, o2) -> o2.score -  o1.score);

        int answer = 0;

        for(Num num: pq){
            answer += num.score * deq.poll();
        }
        System.out.println(answer);
    }
    static boolean containS(String str){
        for(Num num : pq){
            if(num.equalsS(str)){
                return true;
            }
        }
        return false;
    }

}
