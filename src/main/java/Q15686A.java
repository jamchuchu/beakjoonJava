import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q15686A {
    static int n, m;
    static int[][] map;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0, new int[m]);
        System.out.println(minDist);
    }

    static void dfs(int depth, int start, int[] selectedChickens) {
        if (depth == m) {
            calculateMinDist(selectedChickens);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            selectedChickens[depth] = i;
            dfs(depth + 1, i + 1, selectedChickens);
        }
    }

    static void calculateMinDist(int[] selectedChickens) {
        int totalDist = 0;
        for (int[] house : houses) {
            int houseDist = Integer.MAX_VALUE;
            for (int idx : selectedChickens) {
                int[] chicken = chickens.get(idx);
                houseDist = Math.min(houseDist, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
            }
            totalDist += houseDist;
        }
        minDist = Math.min(minDist, totalDist);
    }
}
