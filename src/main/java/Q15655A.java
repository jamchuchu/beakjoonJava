import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15655A {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        List<Integer> arr = new ArrayList<>();
        dfs(n, m, 0, arr);
    }

    static void dfs(int n, int m, int depth, List<Integer> arr) {
        if (depth == m) {
            System.out.print("완성 ");
            for (int i : arr) {
                System.out.print(nums[i-1] + " ");
            }
            System.out.println();
            return;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

//        for (int i = depth == 0? 1 : arr.get(depth-1); i <= n; i++) {
//            arr.add(i);
//            dfs(n, m, depth + 1, arr);
//            arr.remove(arr.size() -1);
//        }

        for (int i = 1; i <= n; i++) {
            if (depth != 0 && i <= arr.get(depth - 1)) {
                continue;
            }
            arr.add(i);
            dfs(n, m, depth + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }
}
