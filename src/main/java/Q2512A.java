import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q2512A {


    //	17548	204
    static int n, m;
    static int answer;
    static ArrayDeque<Integer> values = new ArrayDeque<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        values.addAll(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt)
                .sorted().collect(Collectors.toList()));
        m = Integer.parseInt(reader.readLine());


        while(!values.isEmpty()){
            int now = values.poll();
            if(now * n < m){
                answer = now;
                m -= now;
                n--;
                continue;
            }else{
                answer = m/n;
            }
        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
