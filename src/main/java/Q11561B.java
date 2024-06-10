import java.io.*;

public class Q11561B {
    static int k;
    static Long n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        k =Integer.parseInt(reader.readLine());
        for(int i = 0; i < k; i++) {
            n = Long.parseLong(reader.readLine());
            long answer = binarySearch(n);
            writer.write(answer == 0 ? 1 + "\n" : answer+ "\n");
        }


        writer.flush();
        writer.close();
    }

    public static long binarySearch(long target){
        long start = 0;
        long end = n;
        while(start < end){
            long mid = start + (end - start) /2;
            if(calc(mid) <= target){
                start = mid +1;
            }else{
                end = mid;
            }
        }
        return start-1;
    }

    static long calc(long num){
        return num * (num+1)/2;
    }

}
