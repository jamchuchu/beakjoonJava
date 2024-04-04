import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1092A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> cranes = new ArrayList<>();
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(str[i]));
        }
        Collections.sort(cranes, Collections.reverseOrder());







        int m = Integer.parseInt(reader.readLine());
        str = reader.readLine().split(" ");
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(str[i]));
        }
        Collections.sort(boxes, Collections.reverseOrder());

        if (boxes.get(0) > cranes.get(0)) {
            System.out.println(-1);
        } else {

            int time = 0;
            while (!boxes.isEmpty()) {
                int crIdx = 0;
                int bxIdx = 0;
                while(crIdx < n){
                    if(bxIdx == boxes.size()){
                        break;
                    }
                    if(cranes.get(crIdx) >= boxes.get(bxIdx)){
                        boxes.remove(bxIdx);
                        crIdx++;
                    }else{
                        bxIdx++;
                    }
                }
                time++;
            }
            System.out.println(time);
        }
    }
}
