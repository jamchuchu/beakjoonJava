import java.util.Scanner;

public class Q2941 {
    /*
    * replaceAll 사용
    *
    *17668	204
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(change(str).length());

    }

    public static String change(String str){
        str = str.replaceAll("c=", "0");
        str = str.replaceAll("c-", "0");
        str = str.replaceAll("dz=", "0");
        str = str.replaceAll("d-", "0");
        str = str.replaceAll("lj", "0");
        str = str.replaceAll("nj", "0");
        str = str.replaceAll("s=", "0");
        str = str.replaceAll("z=", "0");
        return str;
    }
}
