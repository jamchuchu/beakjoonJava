import java.io.*;
import java.util.Arrays;

public class Q10815 {

    static int n, m;
    static int[] target, ques;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        target = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        m = Integer.parseInt(reader.readLine());
        ques = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i< m; i++){
            writer.write(binarySort(ques[i]) ? 1 + " " : 0 + " ");
        }

        writer.flush();
        writer.close();
    }

    static boolean binarySort(int stand){
        int start= 0;
        int end = target.length;

        while(start < end){
            int mid = (start + end)/2;
//            System.out.println(start + " " + mid + " " + end);
            if(target[mid] == stand){
                return true;
            }

            if(target[mid] < stand){
                start = mid + 1;
            }else if(target[mid] > stand){
                end = mid;
            }
        }
        return false;
    }

}
