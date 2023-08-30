import java.io.*;
import java.util.*;

public class Q16499 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<List<String>> set = new HashSet<>();

        for (int i =0; i< N; i++){
            List<String> temp =  new ArrayList<>();
            String[] str = br.readLine().split("");
            for (int j=0; j< str.length; j++){
                temp.add(str[j]);
            }
            Collections.sort(temp);
            set.add(temp);
        }

        System.out.println(set.size());

    }
}
