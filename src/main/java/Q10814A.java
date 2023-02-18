import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10814A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        int num = sc.nextInt();
        sc.nextLine();
        String[][] arr =  new String[num][2];

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(sc.nextLine());
            String age = st.nextToken();
            String name = st.nextToken();
            arr[i][0] = age;
            arr[i][1] = name;
        }

        Arrays.sort(arr, (a, b) -> {
           return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
        });

        for(int i = 0; i < num; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
