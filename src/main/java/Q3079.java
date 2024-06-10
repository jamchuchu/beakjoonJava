import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3079 {
    /*
    * max 시간 -> m/n + 1(나머지가 있을때) * 최대값
    * 그시간까지 list에서 배수 더하기
    *
    *
    * */

    static int answer, n, m;
    static long maxTime;
    static int min = Integer.MAX_VALUE;
    static int[] time;
    static List<Long> times = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str =reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        time = new int[n];

        for(int i = 0 ; i< n; i++){
            time[i] = Integer.parseInt(reader.readLine());
            min = Math.min(min, time[i]);
        }
        maxTime = min * m;

        for(int i = 0; i< n; i++){
            long j = time[i];
            while(j <= maxTime){
                times.add(j);
                j += time[i];
            }
        }

        Collections.sort(times);
//        System.out.println(times);
////
//        System.out.println(times.get(m));



        writer.write(times.get(m) + " ");
        writer.flush();
        writer.close();
    }



}
