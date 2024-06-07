import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q1021A {
    /*
    * 뒤에 자기보다 더 작은 값 남아있으면 날릴 수 없음
    *
    * */
    static int n, m, count2, count3;
    static Deque<Integer> que = new LinkedList<>();
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str= reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        answers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        for(int i =  0 ; i< n; i++){
            que.add(i +1);
        }

        for(int i = 0 ; i < m ; i++){
            int target = answers.get(i);
            int min = isMin(i);
//            System.out.println(min);
            System.out.println(target);
            System.out.println(min);

            if(min == target){// 뒤에 작은거 없음, 해당 target 까지 다 날림
                while(que.peek() != target){
                     que.poll();
                }
            }else{// 있음, min 까지 날린후, target 까지 도달
                while(que.peek() != min){
                     que.poll();
                }

                Deque<Integer> temp1 = new ArrayDeque<>(que);
                Deque<Integer> temp2 = new ArrayDeque<>(que);
                int tempCount1 = 0;
                int tempCount2 = 0;

                while(temp1.peek() != target){
                    temp1.add(temp1.poll());
                    tempCount1++;
                    System.out.println(temp1);
                }
                while(temp2.peek() != target){
                    temp2.addFirst(temp2.pollLast());
                    tempCount2++;
                    System.out.println(temp2);

                }

                if(tempCount1 < tempCount2){
                    que = new ArrayDeque<>(temp1);
                    count2 +=tempCount1;
                }else if(tempCount1 > tempCount2){
                    que = new ArrayDeque<>(temp2);
                    count3 += tempCount2;
                }
                System.out.println(que);
                System.out.println(count2 + " " + count3);
            }


        }






        writer.flush();
        writer.close();
    }

    private static int isMin(int idx) {
        int min = answers.get(idx);
        for(int i = idx +1; i < m ; i++){
            min = Math.min(min, answers.get(i));
        }
        return min;

    }


}
