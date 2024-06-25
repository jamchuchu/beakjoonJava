import java.io.*;
import java.util.*;

public class Q14719 {

    static class Tower{
        int height, idx;

        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }


    static int answer, n,m;
    static PriorityQueue<Tower> towers = new PriorityQueue<>((o1, o2) -> o1.height - o2.height);
    static List<Integer> nums = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        for(int i= 0;  i< m ; i++){
            nums.add(Integer.parseInt(str[i]));
            towers.add(new Tower(Integer.parseInt(str[i]), i+1));
        }

        List<Tower> targets = new ArrayList<>();


        while(!towers.isEmpty()){
            Tower t = towers.poll();
            int right = 0;
            int left = 0;
            boolean flag = false;
            ArrayDeque<Tower> temp = new ArrayDeque<>(towers);
            for(Tower side: temp){
                if(side.height > t.height){
                    if(side.idx > t.idx){
                        right = side.idx;
                    }else{
                        left = side.idx;
                    }
                    if(right != 0 && left != 0){
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                targets.add(t);
            }
        }

//        System.out.println(targets);
        Collections.sort(targets, (o1, o2) -> o1.idx - o2.idx);
//        targets.forEach(i -> System.out.println(i.idx));


        Tower pre = targets.get(0);
        for(int j = 1 ; j < targets.size() ; j++){
            Tower now = targets.get(j);
            int min = Math.min(pre.height, now.height);


            for(int i = pre.idx ; i< now.idx -1; i++){
                answer += min- nums.get(i) ;
            }
            pre = now;
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
