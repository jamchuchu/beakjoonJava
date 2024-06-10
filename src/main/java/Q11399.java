import java.io.*;
import java.util.Arrays;

public class Q11399 {

    /*
    * 	16332	164
    *
    * 정렬 후 누적합 의 합
    * */

    static int n, answer;
    static int[] people;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        people = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(people);

        sum = new int[n];
        sum[0] = people[0];
        for(int i = 1 ; i < n; i++){
            sum[i] = sum[i-1] + people[i];
        }
        answer = Arrays.stream(sum).sum();

        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }



}
