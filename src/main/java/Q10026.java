import java.util.Scanner;

public class Q10026 {

    static String[][] arr;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void  main(String[] args){

        Scanner sc =  new Scanner(System.in);

        int num =  sc.nextInt();
        arr = new String[num][num];
        v = new boolean[num][num];
        sc.nextLine();

        for(int i =0; i< num; i++){
            arr[i] = sc.nextLine().split("");
        }

        int a = 0;

        for(int i =0; i< num; i++){
            for(int j =0; j<num; j++){
                if(!v[i][j]) {
                    a++;
                    dfs(i, j);
                }
            }
        }

        System.out.print(a+" ");

        a = 0;

        for(int i =0; i< num; i++){
            for(int j =0; j<num; j++){
                if(arr[i][j].equals("G")){
                    arr[i][j] = "R";
                }
            }
        }


        v = new boolean[num][num];

        for(int i =0; i< num; i++){
            for(int j =0; j<num; j++){
                if(!v[i][j]) {
                    dfs(i, j);
                    a++;
                }
            }
        }

        System.out.println(a);

    }

    static void dfs(int x, int y){
        v[x][y] =  true;
        for(int i =0; i<4; i++){
            int xx = x+dx[i];
            int yy = y+dy[i];
            if(-1< xx && xx< arr.length && -1< yy && yy<arr.length){
                if(!v[xx][yy]) {
                    if(arr[x][y].equals(arr[xx][yy])) {
                        dfs(xx, yy);
                    }
                }
            }
        }
    }
}
