import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q09 {

    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line);
        arr =  new int[a];

        for (int i =0 ; i < a ;  i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int b = Integer.parseInt(bf.readLine());
        line = bf.readLine();
        st = new StringTokenizer(line);

        for(int i =0 ; i < b; i++){
            int num = Integer.parseInt(st.nextToken());
            sort(num);
        }
    }

    public static void sort(int num){
        int st = 0;
        int end = arr.length -1;
        int mid;

        while(st <= end){

            mid = (st+end)/2;

            if(num< arr[mid]){
                end = mid -1;
            }else if(num > arr[mid]){
                st = mid +1;
            }else{
                System.out.println(1+" ");
                return;
            }
        }
        System.out.println(0+" ");
    }

}
