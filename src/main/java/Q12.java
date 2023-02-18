import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q12 {
    static List<Integer>[] list;
    static boolean[] v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int point= Integer.parseInt(st.nextToken());
        int line= Integer.parseInt(st.nextToken());
        int count =0;

        list = new ArrayList[point];
        v = new boolean[point];


        for (int i=0; i< point; i++) {
            list[i] = new ArrayList<>();
        }


        for(int i=0; i<line; i++) {
            st = new StringTokenizer(sc.nextLine());

            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

           list[a-1].add(b);
           list[b-1].add(a);

        }

        for(int i =0; i< point; i++) {
            if(!v[i]) {
                count++;
                search(i);
            }
        }

        System.out.println(count);
    }





    public static void search(int a){
        if(v[a]) {
            return;
        }
        v[a] = true;
        list[a].forEach(num -> {
            if (!v[num-1]) {
                search(num-1);
            }
        });



    }
}
