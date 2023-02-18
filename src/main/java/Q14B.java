import java.util.Scanner;
import java.util.StringTokenizer;

public class Q14B {
    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));

        String line =  sc.nextLine();
        StringTokenizer st = new StringTokenizer(line);

        int m =  Integer.parseInt(st.nextToken());
        int n =  Integer.parseInt(st.nextToken());

        int[][] arr =  new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
