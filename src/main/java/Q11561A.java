import java.io.*;

public class Q11561A {

    /* 이하 idx 찾기  -> upperbound -1 */

    static int k;
    static long n;
    static long[] targets;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        k =  Integer.parseInt(reader.readLine());
        targets = new long[100000001];
        for(int i = 1 ; i< targets.length; i++){
            targets[i] = targets[i-1] + i;
        }

        for(int i = 0; i < k; i++) {
            n = Long.parseLong(reader.readLine());
            long idx = binarySearch(n);
            writer.write(String.valueOf(idx) + "\n");
        }

        writer.flush();
        writer.close();
    }


    public static int binarySearch(long target){
        int start = 0;
        int end = targets.length;
        while(start < end){
            int mid = start + (end - start) /2;
            if(targets[mid] <= target){
                start = mid +1;
            }else{
                end = mid;
            }
        }
        return start-1;
    }

}
