import java.io.*;
import java.util.*;

public class Q17140A {

    static class Number {
        int num, count;

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static int answer, r, c, k;
    static int[][] arr = new int[100][100];
    static int rowSize = 3, colSize = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        r = Integer.parseInt(str[0]) - 1;
        c = Integer.parseInt(str[1]) - 1;
        k = Integer.parseInt(str[2]);

        for (int i = 0; i < 3; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        while (answer <= 100) {
            if (r < rowSize && c < colSize && arr[r][c] == k) {
                break;
            }
            if (rowSize >= colSize) {
                operationR();
            } else {
                operationC();
            }
            answer++;
        }

        writer.write((answer > 100 ? -1 : answer) + "\n");
        writer.flush();
        writer.close();
    }

    static void operationR() {
        int maxCol = 0;
        for (int i = 0; i < rowSize; i++) {
            List<Number> numbers = sortCount(arr[i], colSize);
            int idx = 0;
            for (Number num : numbers) {
                if (idx >= 100) break;
                arr[i][idx++] = num.num;
                arr[i][idx++] = num.count;
            }
            for (int j = idx; j < 100; j++) {
                arr[i][j] = 0;
            }
            maxCol = Math.max(maxCol, idx);
        }
        colSize = Math.min(maxCol, 100);
    }

    static void operationC() {
        int maxRow = 0;
        for (int j = 0; j < colSize; j++) {
            int[] column = new int[rowSize];
            for (int i = 0; i < rowSize; i++) {
                column[i] = arr[i][j];
            }
            List<Number> numbers = sortCount(column, rowSize);
            int idx = 0;
            for (Number num : numbers) {
                if (idx >= 100) break;
                arr[idx++][j] = num.num;
                arr[idx++][j] = num.count;
            }
            for (int i = idx; i < 100; i++) {
                arr[i][j] = 0;
            }
            maxRow = Math.max(maxRow, idx);
        }
        rowSize = Math.min(maxRow, 100);
    }

    static List<Number> sortCount(int[] line, int size) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (line[i] == 0) continue;
            countMap.put(line[i], countMap.getOrDefault(line[i], 0) + 1);
        }

        List<Number> numbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            numbers.add(new Number(entry.getKey(), entry.getValue()));
        }

        numbers.sort((a, b) -> {
            if (a.count == b.count) return a.num - b.num;
            return a.count - b.count;
        });

        return numbers;
    }
}