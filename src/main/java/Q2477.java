import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2477 {
    /*
    *
    * 방향으로 했을때 집합 길이 2개인것 가로 세로
    * 가로 세로의 다음 다음은 먹힌 사각형의 가로 세로
    *
    * 방향안쓰는게 빠를듯
    *덱 넣어서 돌리다가 제일 긴것 발견하면 앞뒤 중 큰것 세로
    * 짧은 쪽의 다음 먹힌 사각형의 시작
    *
    *
    * 	14284	124
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        Deque<Integer> deq = new ArrayDeque<>();
        int max = 0;
        for(int i =0; i< 6; i++){
            String[] str = reader.readLine().split(" ");
            int n = Integer.parseInt(str[1]);
            deq.add(n);
            max = Math.max(max, n);
        }

        int n = 0;
        while(true){
            n = deq.poll();
            if(n == max){
                break;
            }
            deq.add(n);
        }
        int pre = deq.pollLast();
        int post = deq.poll();

        int bigSq = max * Math.max(pre, post);

        int smallSq = 0;
        if(pre < post){
            smallSq = deq.pollLast() * deq.pollLast();
        }else{
            smallSq = deq.poll() * deq.poll();
        }

        System.out.println((bigSq - smallSq) * num);

    }
}
