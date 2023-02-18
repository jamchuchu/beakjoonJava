import java.util.*;

public class Q19 {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);

        int num  = sc.nextInt();
        sc.nextLine();

        List<Integer> list = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        float max = Float.valueOf(Collections.max(list));
        List<Float> list2 = new ArrayList<Float>();

        for(int i = 0; i < list.size(); i++){
            list2.add( Float.valueOf(list.get(i))/max *100);
        }

        float total = 0;
        for(int i = 0; i < list.size(); i++){
            total += list2.get(i);
        }

        System.out.println(total/list.size());


    }


}
