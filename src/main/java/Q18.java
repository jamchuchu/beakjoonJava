import java.util.*;

public class Q18 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            arr.add(i + 1);

        }

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 28; i++) {
            int a = sc.nextInt();
            arr.remove(a);
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}

