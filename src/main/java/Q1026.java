import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt((st.nextToken()));

        int[] b = new int[a];
        int[] c = new int[a];
        st = new StringTokenizer(sc.nextLine());
        for(int i = 0; i < a; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(sc.nextLine());

        for(int i = 0; i < a; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(b);
        Arrays.sort(c);

        int sum = 0;
        for(int i = 0; i < a; i++) {
            sum += b[i] * c[a-1-i];
        }

        System.out.println(sum);


    }
}
