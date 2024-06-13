import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q14890 {
    static int answer, n,l;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        l = Integer.parseInt(str[1]);
        map = new int[n][n];
        for(int i = 1 ; i< n; i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        ArrayDeque<Integer> deq  = new ArrayDeque<>();
        for(int i = 0 ; i< n; i++){
            deq.add(map[0][i]);
        }

        boolean flag = true;
        int pre = deq.poll();
        List<Integer> part = new ArrayList<>();
        while(!deq.isEmpty()){
            int now = deq.poll();
            if(check1(now, pre)){
                continue;
            }else{
                if(part.size() < l+1){
                    part.add(pre);
                    pre = now;
                    continue;
                }else{
                    if(part.get(0) == part.get(1)){
                        if(check2(part)){
                            for(int i = 0; i< l; i++){
                                part.remove(i);
                            }
                            continue;
                        }else{
                            part.remove(0);
                            continue;
                        }
                    }else {
                        if (check2(part)) {
                            for (int i = 0; i < l; i++) {
                                part.remove(i);
                            }
                            continue;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }

        writer.write(answer);
        writer.flush();
        writer.close();
    }

    static boolean check1(int pre , int post){
        if(Math.abs(pre - post) == l){
            return true;
        }
        return false;
    }

    static boolean check2(List<Integer> list){
        int size = list.size();
        if(list.get(0) == list.get(1)){
            for(int i = 1; i < size-1; i++){
                if(list.get(0) != list.get(i)){
                    return false;
                }
            }
            if (list.get(size -1) - list.get(0) != 1) {
                return false;
            }
        }else if(list.get(0) - list.get(1) == 1){
            for(int i = 1; i < size; i++){
                if(list.get(0) != list.get(i)){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

}
