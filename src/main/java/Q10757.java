import java.util.*;

class Q10757
{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list =  new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        int num = Collections.max(list);

        int[] arr = new int[num+1];

        for(int i = 0; i< arr.length; i++ ){
            arr[i] = i;
        }
        arr[1] = 0;

        int i = 2;
        while(i < num){
            if(arr[i] == 0){
                continue;
            }
            int j = 2;

            while(i*j <= num){
                arr[i*j] = 0;
                j++;
            }
            i++;
        }

        int count = 0;
        for(int k = 0; k < list.size(); k++ ){
            if(arr[list.get(k)] != 0){
                count++;
            }
        }
        System.out.println(count);

    }
}