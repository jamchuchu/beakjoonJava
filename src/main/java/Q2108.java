import java.util.*;

public class Q2108 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        double num = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map =  new HashMap<>();
        double sum = 0;

        for(int i = 0; i < num; i++) {
            int x = sc.nextInt();
            sum += x;
            list.add(x);
            if(map.get(x) != null) {
                map.put(x, map.get(x)+1);
            }else{
                map.put(x, 1);
            }
        }

        Collections.sort(list);

        System.out.println(Math.round(sum/num));

        System.out.println(list.get((int)num/2));

        int maxValue = 0;
        List<Integer> maxKey = new ArrayList<>();

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> iter =  iterator.next();
            if( iter.getValue() > maxValue){
                maxValue = iter.getValue();
                maxKey =  new ArrayList<>();
                maxKey.add(iter.getKey());
            }else if(iter.getValue() == maxValue){
                maxKey.add(iter.getKey());
            }
        }

        Collections.sort(maxKey);

        if(maxKey.size() > 1){
            System.out.println(maxKey.get(1));
        }else if(maxKey.size() == 1){
            System.out.println(maxKey.get(0));
        }




        int max = list.get(list.size() - 1);
        int min = list.get(0);

        System.out.println(max - min);



    }
}
