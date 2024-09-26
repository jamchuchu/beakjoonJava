import java.io.*;
import java.math.BigInteger;

public class Q1011 {
    static int t;
    static BigInteger x, y, dist;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(reader.readLine());
        while(t != 0){
            t--;

            String[] str = reader.readLine().split(" ");
            x = new BigInteger(str[0]);
            y = new BigInteger(str[1]).subtract(BigInteger.ONE);
            dist = y.subtract(x);

            System.out.println(binary(dist).add(BigInteger.ONE));
        }

//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }


    static BigInteger binary(BigInteger target){
        BigInteger start = BigInteger.ZERO;
        BigInteger end = dist;
        while(start.compareTo(end) < 0){
//            System.out.println(start + " " + end);
            BigInteger mid = start.add(end.subtract(start).divide(BigInteger.TWO));
            if(calc(mid).compareTo(target) < 0){
                start = mid.add(BigInteger.ONE);
            }else{
                end = mid;
            }
        }
        return end;
    }

    static BigInteger calc(BigInteger mid){
        return ((mid.add(BigInteger.ONE)).multiply(mid)).divide(BigInteger.TWO);
    }

}
