import java.io.*;
import java.util.*;

public class Q1713 {

    static int n, m;
    static String[] nums;

    static List<String> list = new ArrayList<>();
    static Map<String, Integer> candi = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        nums = reader.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            String current = nums[i];
            if (candi.containsKey(current)) {
                candi.put(current, candi.get(current) + 1);
            } else {
                if (candi.size() >= n) {
                    // 최솟값 구하기
                    int min = Collections.min(candi.values());
                    String toRemove = null;
                    for (String key : list) {
                        if (candi.get(key) == min) {
                            toRemove = key;
                            break;
                        }
                    }
                    candi.remove(toRemove);
                    list.remove(toRemove);
                }
                candi.put(current, 1);
                list.add(current);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (String s : list) {
            result.add(Integer.parseInt(s));
        }
        Collections.sort(result);
        for (int num : result) {
            writer.write(num + " ");
        }

        writer.flush();
        writer.close();
    }
}
