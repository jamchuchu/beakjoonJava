import java.util.*;

public class Q1339B {
    static int n;
    static int[] score = new int[26];

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
                int num = s.charAt(0)-65;
                score[num] += (int) (Math.pow(10, size));
                size++;
            }
        }

        Arrays.sort(score);
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            deq.add(9 - i);
        }

        int answer = 0;
        for(int i = 0; i< 26; i++){
            if(score[25-i] == 0){
                break;
            }
            answer += score[25-i] * deq.poll();
        }

        System.out.println(answer);
//        System.out.println(map);
    }
}