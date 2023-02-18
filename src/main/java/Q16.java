import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        arr = new int[num + 1];

        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        try {
            for (int i = 4; i < num + 1; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1] + 1);
                if (i % 2 == 0) {
                    list.add(arr[i / 2] + 1);
                }
                if (i % 3 == 0) {
                    list.add(arr[i / 3] + 1);
                }
                Collections.sort(list);

                arr[i] = list.get(0);
            }
            System.out.println(arr[num]);
        }catch(Exception e) {}
    }

}
