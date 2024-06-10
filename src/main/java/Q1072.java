import java.io.*;

public class Q1072 {

    static int x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);
        int z = calc(0);



        writer.write(x==y || calc(0) == 99 ? -1 + "\n" :  binarySearch(z + 1) + "\n");
        writer.flush();
        writer.close();
    }

    static int binarySearch(int target){
        int start = 0;
        int end = x;
        while(start < end){
            int mid = start + (end - start) / 2;
            System.out.println(calc(mid));
            if(calc(mid) < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    static int calc(int mid) {
        long newX = x + mid;
        long newY = y + mid;
        return (int) ((newY * 100) / newX);
    }

}
