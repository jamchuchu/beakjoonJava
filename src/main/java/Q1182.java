import java.util.*;

public class Q1182 {
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

        for(int count =1; count< num; count++) {
            select = new int[count];
            dfs(0, count);
        }
        System.out.print(set.size());
    }

    static void dfs(int depth, int count){
        if(depth == count){
            int sum =0;
            Set<Integer> temp = new HashSet<>();
            for(int a:  select){
                sum += a;
                temp.add(a);
            }
            if(sum == target) {
                set.add(temp);
            }
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
}
