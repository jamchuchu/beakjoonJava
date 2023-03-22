import java.util.*;

public class Q2562 {
    public static void main(String[] args) {

        List<Integer> a =  new ArrayList<>();

        Scanner sc =  new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            a.add( sc.nextInt());
        }
        int max =  Collections.max(a);
        System.out.println(max);
        System.out.println(a.indexOf(max)+1);

    }
}
