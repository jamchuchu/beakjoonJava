import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24313 {
    /*
    * 문제의식을 직접 만족 하고 모두가 양수라고 했으니
    * 나누는 것 만 주의하면 될듯 하다( c-a1 > 0)
    *
    * 14196	120
    *  */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int a0 = Integer.parseInt(str[1]);
        int a1 =  Integer.parseInt(str[0]);
        int c =  Integer.parseInt(reader.readLine());
        int n =  Integer.parseInt(reader.readLine());

        if(a1 * n + a0 <= c*n && c >= a1){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }


}
