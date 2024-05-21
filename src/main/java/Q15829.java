import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q15829 {
    static String str;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        str = reader.readLine();
        BigInteger result = new BigInteger("0");
        for(int i = 0; i < n ; i++){
            result = result.add(BigInteger.valueOf(str.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
        }
        System.out.println(result.modPow(new BigInteger("1"), new BigInteger("1234567891")));
     }
}
