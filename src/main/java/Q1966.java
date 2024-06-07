import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q1966 {
    static int k,m;
    static Deque<Docu> que = new LinkedList<>();


    static class Docu{
        int idx;
        int rank;

        public Docu(int idx, int rank){
            this.idx = idx;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(reader.readLine());

        for(int i = 0 ; i< k; i++){

            //입력
            String[] str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            que = new LinkedList<>();
            str = reader.readLine().split(" ");

            for (int j = 0 ; j< a; j++){
                que.add(new Docu(j, Integer.parseInt(str[j])));
            }

            int count = 0;
            while(!que.isEmpty()) {
                Docu docu = que.poll();
                if (findBack(docu.rank)) {// 뒤에 중요도가 더 높은 문서가 있는가?
                    count++;
                    if (docu.idx == b) {// 없다 프린트
                        break;
                    }
                } else {
                    que.addLast(docu);
                }
            }

            System.out.println(count);

        }
    }

    static boolean findBack(int rank){
        List<Docu> temp = new ArrayList<>(que);
        for(int i = 0 ; i< temp.size(); i++){
            if(temp.get(i).rank > rank){
                return false;
            }
        }
        return true;
    }

}
