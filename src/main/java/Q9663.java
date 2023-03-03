import java.util.*;

class Q9663{
    static List<int[]> arr;
    static int[][] v;
    static int count;
    static int[] dx ;
    static int[] dy ;
    static int[] posi;
    static boolean[] posiv;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num =  sc.nextInt();

        arr = new ArrayList<>();
        v =  new int[num][num];
        posi =  new int[num];
        posiv =  new boolean[num];


        System.out.println(count);

    }

    static void dfs(int num, int depth, int i, int j){
        if(depth == num-1){
            count++;
            printQ(arr);
            print(v);
            return;
        }
//        if(v[i][j]== 0){
//            for(int k = 0; k < num; k++) { //queen effect
//
//                dx = new int[]{i, i, i+k, i+k, i+k, i-k, i-k, i-k};
//                dy = new int[]{j+k, j-k, j+k, j, j-k, j+k, j, j-k};
//
//                for(int l = 0; l < 8; l++) {
//                     if (-1 < dx[l] && dx[l] < num && -1 < dy[l] && dy[l] < num) {
//                          v[dx[l]][dy[l]] = 1;
//                     }
//                }
//                v[i][j] = 8; // queen posi
//            }

            printQ(arr);
            print(v);

            arr.add(depth, new int[]{i, j});

            for(int k = 0; k < num; k++){
                for(int l = 0; l < num; l++){
                    dfs(num, depth+1 , k, l);
                }
            }
        }



    static void print(int[][] v){
        for(int i=0; i<v.length; i++){
            for(int j = 0; j< v.length; j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printQ(List<int[]> q){
        System.out.print("//");
        for(int i=0; i<q.size(); i++){
            int[] temp = q.get(i);
            System.out.print("["+temp[0]+", ");
            System.out.print(temp[1]+"], ");
        }
        System.out.println("/ "+ q.size());
    }
}