import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Q1021B {

    static LinkedList<Integer> deq = new LinkedList<>();
    static int[] target;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for(int i = 1; i <= n; i++) {
            deq.add(i);
        }

        target = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i< m; i++){
            int targetIdx = deq.indexOf(target[i]);
            int halfIdx = 0;
            if(deq.size() % 2 == 0) {
                halfIdx = deq.size() / 2 - 1;
            }
            else {
                halfIdx = deq.size() / 2;
            }

            if(targetIdx <= halfIdx) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
                for(int j = 0; j < targetIdx; j++) {
                    int temp = deq.pollFirst();
                    deq.offerLast(temp);
                    count++;
                }
            }else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우
                // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
                for(int j = 0; j < deq.size() - targetIdx; j++) {
                    int temp = deq.pollLast();
                    deq.offerFirst(temp);
                    count++;
                }

            }
            deq.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
        }

        writer.write(String.valueOf(count));
        writer.flush();
        writer.close();
    }
}
