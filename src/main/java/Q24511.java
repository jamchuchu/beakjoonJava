import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q24511 {

    static int n,m;
    static Deque<Integer> arr = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        String[] type = reader.readLine().split(" ");
        String[] str = reader.readLine().split(" ");
        for(int i = 0 ; i< n; i++){
            if(Integer.parseInt(type[i]) == 0){
                arr.add(Integer.parseInt(str[i]));
            }
        }
        m = Integer.parseInt(reader.readLine());


        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < m; i++){
            arr.addFirst(Integer.parseInt(st.nextToken()));
            writer.write(arr.pollLast() + " ");
        }

        writer.flush();
        writer.close();
    }


}
