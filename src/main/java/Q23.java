import java.util.Scanner;

public class Q23 {

    public static void main(String[] args) {
        String[] a =  {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Scanner sc = new Scanner(System.in);

        String line= sc.nextLine();
        for (int i = 0; i < a.length; i++) {
            line = line.replace(a[i], "Z");
        }
        System.out.println(line.length());
    }
}
