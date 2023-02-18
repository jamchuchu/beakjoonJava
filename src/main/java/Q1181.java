import java.util.*;

class Q1181{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        SortedMap<String, Integer> map = new TreeMap<>();

        for(int i =0; i< num; i++){
            String x = sc.next();
            map.put(x, x.length());
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort((Map.Entry.comparingByValue()));

        entryList.forEach(entry ->{
            System.out.println(entry.getKey());
        });





    }
}