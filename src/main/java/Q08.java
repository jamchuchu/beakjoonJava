import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q08 {

    static int start, end;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //M
        int M = Integer.parseInt(br.readLine());
        arr =  new int[M];

        String line= br.readLine();
        StringTokenizer st = new StringTokenizer(line);


        for(int i = 0; i < M ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        //N
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i= 0; i< N ; i++){
            int num =Integer.parseInt(st.nextToken());
            sort(num);
                if (st.hasMoreTokens()) {
                    System.out.print(" ");
                }
            }
        }


    public static void sort(int num) {
        start = 0;
        end = arr.length-1;
        int mid;

        while (start <= end) {
            mid = (start + end)/ 2;

            if (num < arr[mid]) {
                end = mid - 1;
            } else if (num > arr[mid]) {
                start = mid + 1;
            } else {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }

    private static int BinarySearch(int target){
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right){
            mid = (left + right) / 2;
            if(arr[mid] < target)
                left = mid + 1;
            else if(arr[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }

}
