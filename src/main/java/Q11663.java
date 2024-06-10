import java.io.*;
import java.util.Arrays;

public class Q11663 {

    /*
    * startIdx 같거나 큰애들
    * endIdx 같거나 작은애들
    *
    * 	73828	1028
    *
    * */
    static int n, m;
    static int[] target;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        target = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt)
                .sorted().toArray();

        for(int i = 0; i < m; i++){
            str =reader.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            int startIdx = 0;
            if(start > target[0]){
                startIdx = binarySearchForStart(start);
            }
            int endIdx = n -1;
            if(end < target[n-1]){
                endIdx = binarySearchForEnd(end);
            }
//            writer.write(startIdx + " " +  endIdx + "\n");
            writer.write(endIdx - startIdx +1 + "\n");

        }


        writer.flush();
        writer.close();
    }

    public static int binarySearchForStart(int stand){
        int start = 0;
        int end = n;
        int mid = n/2;

        while(start < end){
//            System.out.println(start + " " + mid + " " + end);
            if(target[mid] == stand){
                return mid;
            }

            if(target[mid] < stand){
                start = mid + 1;
            }else if(target[mid] > stand){
                end = mid;
            }
            mid = (start + end) /2;

        }
        return mid;

    }

    public static int binarySearchForEnd(int stand){
        int start = 0;
        int end = n;
        int mid = n/2;

        while(start < end){
//            System.out.println(start + " " + mid + " " + end);
            if(target[mid] == stand){
                return mid;
            }

            if(target[mid] < stand){
                start = mid + 1;
            }else if(target[mid] > stand){
                end = mid ;
            }
            mid = (start + end) /2;
        }
        return mid-1;

    }


}
