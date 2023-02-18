import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q05 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lastDay = Integer.parseInt(st.nextToken());
        List<int[]> workList = new ArrayList<>();
        for(int i = 0 ;  i< lastDay ; i++){
            st = new StringTokenizer(br.readLine());
            String[] strWorkList = st.nextToken().split(" ");
            int[] workListofDay =  new int[strWorkList.length];
            workListofDay[0] = Integer.parseInt(strWorkList[0]);
            workListofDay[1] = Integer.parseInt(strWorkList[1]);
            workList.add(workListofDay);
        }

        boolean[] myWork = new boolean[lastDay];
        int money = 0;
        int day = 1;

    }
}


