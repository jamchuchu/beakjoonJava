import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Q1181A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.length() == o2.length()){ return o1.compareTo(o2);}
            return o1.length() - o2.length();
        });

        pq.addAll(set);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
