import java.util.*;

class Q15650{

    static int[] arr;
    static int[] select;
    static boolean[] v;
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        int m = sc. nextInt();

        arr = new int[num];
        v = new boolean[num];
        select =  new int[m];

        for(int i = 0; i < num; i++){
            arr[i] = i+1;
        }

        dfs(num, m, 0);
    }

    static void dfs(int num, int m, int depth){
        if(m == depth){
            for(int i =0; i< select.length; i++){
                System.out.print(select[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i =0; i< num; i++) {
            if (!v[i]) {
                v[i] = true;
                if(depth == 0){
                    select[depth] = arr[i];
                    dfs(num, m, depth + 1);
                    v[i] = false;
                } else if(select[depth-1] < arr[i]) {
                    select[depth] = arr[i];
                    dfs(num, m, depth + 1);
                    v[i] = false;
                }
                v[i] = false;
            }
        }
    }
}