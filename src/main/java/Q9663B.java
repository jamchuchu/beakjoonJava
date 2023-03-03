import java.util.Scanner;

public class Q9663B {
    static int[][] v;
    static int[] select;
    static int count;
    static int num;
    static int[] dx ;
    static int[] dy ;

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        num = sc.nextInt();

        select =new int[num];
        v = new int[num][num];

        dfs(0);
        System.out.println(count);
    }

    static void dfs(int depth){
        if(depth == num){
            count++;
            return;
        }
        for(int m = 0; m < num; m++) {
//            if(v[depth][m] != 0){
//                continue;
//            }
            int i = depth;
            int j = m;
            if (v[i][j] == 0) {

                // 방문시 추가
                for (int k = 0; k < num; k++) { //queen effect

                    dx = new int[]{i, i, i + k, i + k, i + k, i - k, i - k, i - k};
                    dy = new int[]{j + k, j - k, j + k, j, j - k, j + k, j, j - k};

                    for (int l = 0; l < 8; l++) {
                        if (-1 < dx[l] && dx[l] < num && -1 < dy[l] && dy[l] < num) {
                            v[dx[l]][dy[l]] = 1;
                        }
                    }
                    v[i][j] = 8; // queen posi

                }








                select[depth] = m;
                dfs(depth + 1);
                print(select);
                print(v);
            }
        }

    }

    static void print(int[] posi){
        for(int i=0; i < posi.length; i++){
            System.out.print(posi[i]+ " ");
        }
        System.out.println();
    }

    static void print(int[][] posi){
        for(int i=0; i<num; i++) {
            for (int j = 0; j <num; j++) {
                System.out.print(posi[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
