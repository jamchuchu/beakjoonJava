import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501A {
    static int n;
    static int[] day, pay, workingDay;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        day = new int[n + 1];
        pay = new int[n + 1];
        workingDay = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            int time = i;
            while (time <= n) {
                if (time + day[time] <= n+1) {
                    count += pay[time];
                    time += day[time];
                } else {
                    time++;
                }
            }
            answer = Integer.max(answer,count);
        }
        System.out.println(answer);
    }
}
