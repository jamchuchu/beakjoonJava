import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1182A {
    static int[] arr;
    static boolean[] v;
    static int num;
    static int target;
    static int[] select;
    static Set<Set<Integer>> set;
    static int answer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        target = sc.nextInt();

        arr = new int[num];
        for(int i =0; i < num; i++){
            arr[i] = sc.nextInt();
        }
        v= new boolean[num];
        set = new HashSet<>();

//        for(int count =1; count< num; count++) {
//            select = new int[count];
//            dfs(0, count);
//        }

        select =  new int[2];
        dfs(0,2);
        System.out.print(set.size());
    }

    static void dfs(int depth, int count){
        if(depth == count){
            for(int a: select){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for(int i =0; i< num; i++) {
            if (!v[i]) {
                v[i] = true;
                select[depth] = arr[i];
                dfs(depth+1, count);
                v[i] = false;
            }
        }


    }
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
//            print(arr, visited, n);
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }
}
