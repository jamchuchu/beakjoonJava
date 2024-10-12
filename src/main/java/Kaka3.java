public class Kaka3 {

    static int[] arr = {0,3,0,0,5,0,5};
    static boolean[] visit = new boolean[arr.length];
    public static void main(String[] args) {
        int[] target = {4,2,6,1,0};

        visit[0] = true;
        for(int i : target){
            dfs(i);
        }

        int count = 0;
        for(boolean b : visit){
            if(b){
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int n){
        if(n == 0){
            return;
        }
        if(visit[n]){
            return;
        }
        visit[n] = true;
        dfs(arr[n]);
    }

}
