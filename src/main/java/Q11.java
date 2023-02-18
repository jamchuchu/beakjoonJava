import java.util.Scanner;
import java.util.StringTokenizer;

public class Q11 {
    static boolean[][] v;
    static String[][] arr;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr = new String[a][b];
        v = new boolean[a][b];
        for(int i = 0; i < a; i++ ){
            arr[i] = sc.nextLine().split("");
        }


        count = 0;


        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(!v[i][j]) {
                    if(arr[i][j].equals("-")){
                        searchRow(i, j);
                    }else{
                        searchCol(i ,j);
                    }
                }
            }
        }

        System.out.println(count);





    }

    public static void searchRow(int row, int col){
        v[row][col] = true;
        col++;
        try{
            if(arr[row][col].equals("-")) {
                searchRow(row, col);
            }else{
                count++;
                return;
            }
        }catch (Exception e){
            count++;
            return;
        }
    }

    public static void searchCol(int row, int col){
        v[row][col] = true;
        row++;
        try{
            if(arr[row][col].equals("|")) {
                searchCol(row, col);
            }else{
                count++;
                return;
            }
        }catch (Exception e){
            count++;
            return;
        }
    }
}
