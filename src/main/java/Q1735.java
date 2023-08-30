import java.util.Scanner;

public class Q1735 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        str = sc.nextLine().split(" ");
        int c = Integer.parseInt(str[0]);
        int d = Integer.parseInt(str[1]);

        int answer1 = (a*d) + (b*c);
        int answer2 = b*d;

        int max = gcd(answer1, answer2);

        System.out.println(answer1/max + " " +answer2/max);

    }


    public static int gcd(int a, int b) {// 유클리드 호제법
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
