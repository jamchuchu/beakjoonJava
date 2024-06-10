import java.io.*;
import java.util.PriorityQueue;

public class Q1417 {

    /*
    * 1등 자신 차/2 만큼 서로 빼고 더함
    * 반복
    * 클때까지
    *
    * */

    static int n;
    static PriorityQueue<Integer> candi = new PriorityQueue<>((o1, o2) -> o2 - o1 );
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        int me = Integer.parseInt(reader.readLine());
        for(int i=0; i< n-1; i++){
            candi.add(Integer.parseInt(reader.readLine()));
        }


        int count = 0;
        while(!candi.isEmpty()){
            if(me == candi.peek()){
                count++;
                break;
            }else if(me >candi.peek()){
                break;
            }
            int first = candi.poll();
            me ++;
            first --;
            count ++;
            candi.add(first);
        }

        writer.write(count + " ");
        writer.flush();
        writer.close();
    }


}
