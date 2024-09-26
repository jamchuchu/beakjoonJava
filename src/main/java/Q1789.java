import java.io.*;
import java.util.LinkedList;

public class Q1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Long n= Long.parseLong(reader.readLine());
        Long answer = 0L;
        if(n != 1) {
            answer = binary(n);
        }else{
            answer = 1L;
        }

        LinkedList<Integer> list = new LinkedList<>();

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static long binary(long target){
        long start = 0;
        long end = target;
        while(start < end){
            long mid = start + (end - start)/2;
            if(calc(mid) <= target){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start-1;
    }

    static long calc(long mid){
        return (mid+1) * mid/2;
    }
}
