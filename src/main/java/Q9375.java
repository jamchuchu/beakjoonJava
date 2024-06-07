import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Q9375 {

    /*
    *
    * 1. 3 * 2 -1
    * 2. 4 -1
    *
    * 	14320	140
    * */



    static int n, m;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0  ; i < n; i++){
            map = new HashMap<>();
            m = Integer.parseInt(reader.readLine());
            for(int j = 0 ; j < m; j++){
                String[] str = reader.readLine().split(" ");
                int count =  map.get(str[1]) == null ? 0 : map.get(str[1]);
                map.put(str[1], count + 1);
            }
            int answer = 1;
            for(Map.Entry<String, Integer> m : map.entrySet()){
                answer *= m.getValue()+1;
            }
            writer.write(String.valueOf(answer-1)+ " ");
        }


        writer.flush();
        writer.close();
    }


}
