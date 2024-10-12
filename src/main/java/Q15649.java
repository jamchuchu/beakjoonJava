import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
* [1,2,3,4]
*
* [t,t,f,f]
*
* [1,2,3,0]
* [1,2,4,]
*
* [1,2,4,0]
*
* */
public class Q15649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        List<Integer> arr = new ArrayList<>();
        dfs(n, m, 0, arr);
    }

    static void dfs(int n, int m, int depth, List<Integer> arr) {
        if (depth == m) {
            System.out.print("완성 ");
//            for (int i = 0; i < m; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

//        for (int i = depth == 0? 1 : arr.get(depth-1); i <= n; i++) {
//            arr.add(i);
//            dfs(n, m, depth + 1, arr);
//            arr.remove(arr.size() -1);
//        }

        for (int i = 1; i <= n; i++) {
            if(depth != 0 && i < arr.get(depth-1)){
                continue;
            }
            arr.add(i);
            dfs(n, m, depth + 1, arr);
            arr.remove(arr.size() -1);
        }
    }
}