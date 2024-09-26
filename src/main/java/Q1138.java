import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[n];


        for(int i = 0; i< n; i++) {
            int idx = i+1;
            int count = 0;
            int j = 0;


            while (true) {
                if (answer[j] != 0) {
                    j++;
                    continue;
                } else {
                    if (count < arr[i]) {
                        count++;
                    } else {
                        answer[j] = idx;
                        break;
                    }
                }
                j++;
            }
        }

        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new LinkedHashMap<>();

        for(int i = 0 ; i< n; i++){
            System.out.print(answer[i] + " ");
        }


//        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
