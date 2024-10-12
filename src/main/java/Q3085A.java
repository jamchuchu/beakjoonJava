import java.util.Scanner;

public class Q3085A {
    static int n;
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int maxCandy = 0;

        // 모든 인접한 두 칸에 대해 교환 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) { // 가로
                    swap(i, j, i, j + 1);
                    maxCandy = Math.max(maxCandy, countCandy());
                    swap(i, j, i, j + 1);
                }
                if (i + 1 < n) { // 세로
                    swap(i, j, i + 1, j);
                    maxCandy = Math.max(maxCandy, countCandy());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(maxCandy);
    }

    static void swap(int i1, int j1, int i2, int j2) {
        char temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
    }

    static int countCandy() {
        int maxCount = 1;

        // 행 체크
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j-1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        // 열 체크
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j] == board[i-1][j]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}