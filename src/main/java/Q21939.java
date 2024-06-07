import java.io.*;
import java.util.*;

public class Q21939 {
    static int n, m;
    static SortedMap<Integer, List<Integer>> pq = new TreeMap<>(); // diff num
    static Map<Integer, Integer> qList = new HashMap<>(); // num diff

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = reader.readLine().split(" ");
            int num = Integer.parseInt(str[0]);
            int diff = Integer.parseInt(str[1]);
            List<Integer> nums = pq.getOrDefault(diff, new ArrayList<>());
            nums.add(num);
            pq.put(diff, nums);
            qList.put(num, diff);
        }

        m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            req(reader.readLine());
        }

        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }

    static void req(String str) {
        String[] strs = str.split(" ");
        if (strs[0].equals("recommend")) {
            sb.append(recommend(Integer.parseInt(strs[1])) + "\n");
        } else if (strs[0].equals("add")) {
            add(Integer.parseInt(strs[1]), Integer.parseInt(strs[2]));
        } else if (strs[0].equals("solved")) {
            solved(Integer.parseInt(strs[1]));
        }
    }

    static int recommend(int i) {
        if (i == 1) {
            return Collections.max(pq.get(pq.lastKey()));
        } else if (i == -1) {
            return Collections.min(pq.get(pq.firstKey()));
        }
        return 0;
    }

    static void add(int num, int diff) {
        List<Integer> nums = pq.getOrDefault(diff, new ArrayList<>());
        nums.add(num);
        pq.put(diff, nums);
        qList.put(num, diff);
    }

    static void solved(int num) {
        int diff = qList.get(num);
        List<Integer> list = pq.get(diff);
        if (list != null) {
            list.remove((Integer) num);
            if (list.isEmpty()) {
                pq.remove(diff);
            } else {
                pq.put(diff, list);
            }
        }
    }
}
