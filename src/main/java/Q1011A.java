import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Q1011A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger x = new BigInteger(st.nextToken());
            BigInteger y = new BigInteger(st.nextToken());
            BigInteger distance = y.subtract(x);

            BigInteger n = sqrt(distance);
            BigInteger nSquared = n.multiply(n);

            if (nSquared.equals(distance)) {
                System.out.println(n.multiply(BigInteger.TWO).subtract(BigInteger.ONE));
            } else if (distance.compareTo(nSquared.add(n)) <= 0) {
                System.out.println(n.multiply(BigInteger.TWO));
            } else {
                System.out.println(n.multiply(BigInteger.TWO).add(BigInteger.ONE));
            }
        }
    }

    // BigInteger의 제곱근을 구하는 메소드
    private static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}