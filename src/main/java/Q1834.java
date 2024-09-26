import java.math.BigInteger;
import java.util.Scanner;

public class Q1834 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger a = new BigInteger(String.valueOf(n));
        BigInteger b = new BigInteger(String.valueOf(n+1));
        BigInteger c = new BigInteger(String.valueOf(n-1));


        BigInteger answer = a.multiply(b).multiply(c).divide(BigInteger.TWO);
        System.out.println(answer);
    }
}
