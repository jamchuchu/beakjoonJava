import java.io.*;
import java.math.BigInteger;

public class Q15829A {
    /*
    * 	14432	124
    * */

    static int n;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        str = reader.readLine();
        BigInteger m = new BigInteger("1234567891");

        BigInteger answer = new BigInteger(String.valueOf((int)str.charAt(0) - 96));
        BigInteger pows = new BigInteger("1");
        BigInteger pow = new BigInteger("31");


        for(int i = 1 ; i< n; i++){
            int a = (int)str.charAt(i) - 96;
            BigInteger b = new BigInteger(String.valueOf(a));
            pows = pows.multiply(pow);

            BigInteger c = b.multiply(pows);
            answer = answer.add(c).remainder(m);
        }
        writer.write(answer.toString());

        System.out.println(answer);



        writer.flush();
        writer.close();
    }
}
