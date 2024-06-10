import java.io.*;
import java.math.BigInteger;

public class Q11834 {

    static BigInteger N, n, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = new BigInteger(reader.readLine());
        n = findSmallN(N); // n(n+1)/2 = N 만족하는 n

        answer = N.multiply(BigInteger.TWO).subtract(n);

        writer.write(answer.toString());
        writer.flush();
        writer.close();
    }

    static BigInteger findSmallN(BigInteger target){
        BigInteger start = new BigInteger(String.valueOf(1));
        BigInteger end = new BigInteger("1" + "0".repeat(100));
        while(start.compareTo(end) == -1){
            BigInteger mid = start.add(end.subtract(start).divide(BigInteger.TWO));
            if(calcSum(mid).compareTo(target) == -1){
                start = mid.add(BigInteger.ONE);
            }else{
                end = mid;
            }
        }
        return start;
    }

    static BigInteger calcSum(BigInteger mid){
        return (mid.multiply (mid.add(BigInteger.ONE))).divide(BigInteger.TWO);
    }



}
