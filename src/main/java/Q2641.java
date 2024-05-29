import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2641 {
    /*
    * 회전, 반전을 허용하지 않으면 결국 하나씩 숫자를 빼서 돌리면 끝이라는 문제
    * Deq에 넣은다음 앞에서 빼서 뒤에서 넣어 전체 set에 넣는다
    * reverse도 고려 반대로 회전 시킬수 있다. 숫자 빼서 1-3,2-4 로 바꿔주고(방향 전환) 넣는다
    * 마찬가지로 앞에서 빼서 뒤로 넣음해서 전체 set에 넣는다
    * contain 확인 하고 return
    * */
    static int n, m;
    static Deque<Integer> basic = new LinkedList<>();
    static Queue<Deque<Integer>> basicSet = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++) {
            basic.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < n; i++) {
            // 정방향
            int temp = basic.pollFirst();
            basic.addLast(temp);

            Deque<Integer> copy = new LinkedList<>();
            copy.addAll(basic);

            basicSet.add(copy);
        }
        Deque<Integer> reverse = reverse(basic);
        for(int i = 0; i < n; i++) {
            // 역방향
            int temp = reverse.pollFirst();
            reverse.addLast(temp);

            Deque<Integer> copy = new LinkedList<>();
            copy.addAll(reverse);

            basicSet.add(copy);
        }

//        basicSet.forEach(i ->
//                System.out.println(i));

        //문제
        st = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(st.nextToken());
        Queue<Deque<Integer>> answers = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            basic = new LinkedList<>();
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++) {
                basic.add(Integer.parseInt(st.nextToken()));
            }
            if(basicSet.contains(basic)){
                answers.add(basic);
            }
        }

        System.out.println(answers.size());
        answers.forEach(i -> {
                    i.forEach(j ->
                            System.out.print(j + " "));
                    System.out.println();
                }
        );

    }
    static Deque<Integer> reverse(Deque<Integer> deq){
        Deque<Integer> newDeq = new LinkedList<>();
        while(!deq.isEmpty()){
            int temp = deq.poll();
            int newNum = 0;
            if(temp == 1){
                newNum = 3;
            }else if(temp == 2){
                newNum = 4;
            }else if(temp == 3){
                newNum = 1;
            }else if(temp == 4){
                newNum = 2;
            }
            newDeq.addFirst(newNum);
        }
        return newDeq;
    }
}
