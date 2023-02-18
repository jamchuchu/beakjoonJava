import java.sql.SQLOutput;
import java.util.*;

class Q21{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("");

        String line= sc.nextLine();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i].toUpperCase();
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

        List<String> keyList = new ArrayList<String>();
        List<Integer> valueList = new ArrayList<Integer>();
        map.forEach((key, value) -> {
            keyList.add(key);
            valueList.add(value);
        });

        int count = 0;
        String answer = null;
        int max = Collections.max(valueList);

        for(int i =0; i < valueList.size(); i++){
            if(valueList.get(i) == max){
                answer = keyList.get(i);
                count++;
            }
        }


        if(count != 1){
            System.out.println("?");
        }else{
            System.out.println(answer);
        }
    }
}