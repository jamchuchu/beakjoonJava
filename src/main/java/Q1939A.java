import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q1939A {

    static int n, m;
    static int[] answers;
    static boolean[][] v;
    static int[][] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        weights = new int[n+1][n+1];
        v = new boolean[n+1][n+1];

        answers = new int[n+1];
        Arrays.fill(answers, 0);  // 변경된 초기화

        for (int i = 0; i < m; i++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = nums[0], b = nums[1], weight = nums[2];
            weights[a][b] = Math.max(weights[a][b], weight);
            weights[b][a] = Math.max(weights[b][a], weight);
        }

        str = reader.readLine().split(" ");
        int startNode = Integer.parseInt(str[0]);
        bfs(startNode);

        writer.write(answers[Integer.parseInt(str[1])] + " ");
        writer.flush();
        writer.close();
    }

    static void bfs(int start) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        answers[start] = Integer.MAX_VALUE;  // 시작 노드 최대값 설정
        deq.add(start);

        while (!deq.isEmpty()) {
            int pre = deq.poll();
            for (int now = 1; now <= n; now++) {
                if (weights[pre][now] == 0) continue;  // 다리 없음
                int possibleStrength = Math.min(answers[pre], weights[pre][now]);
                if (answers[now] < possibleStrength) {
                    answers[now] = possibleStrength;
                    deq.add(now);
                }
            }
        }
    }
}
