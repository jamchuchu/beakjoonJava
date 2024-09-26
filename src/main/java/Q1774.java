import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1774 {

    public static void main(String[] args) {
        int max = 10000000;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        for(int i  = 0; i< max; i++){
            list1.add(i);
            list2.add(i);
        }

        long startTime = System.nanoTime();

        list1.add(max/2, -1);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("ArrayList: " + duration);



        startTime = System.nanoTime();

        list2.add(max/2 , -1);

         endTime = System.nanoTime();
         duration = endTime - startTime;

        System.out.println("LinkedList: " + duration);


    }

}
