import java.io.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Q1213A {

    //	16532	164
    static SortedMap<String, Integer> map = new TreeMap<>();
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split("");
        for(String s :  str){
            int num = map.getOrDefault(s, 0);
            map.put(s, num+1);
        }
        int count = 0;
        String oddStr = "";
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> m: map.entrySet()){
            if(m.getValue() % 2 == 1) {
                oddStr = m.getKey();
                count++;
            }
            for(int i = 0; i< m.getValue()/2; i++){
                sb.append(m.getKey());
            }
        }

        if(count <= 1) {
            answer = sb.toString() + oddStr + sb.reverse().toString();
        }else{
            answer = "I'm Sorry Hansoo";
        }


        writer.write(answer);
        writer.flush();
        writer.close();
    }


}
