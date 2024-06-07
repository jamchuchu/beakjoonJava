import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2615A {
    static int[][] map = new int[19][19];
    static int[] dx = {0, 1, 1, 1}; // Right, Down, Diagonal Right Down, Diagonal Left Down
    static int[] dy = {1, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (win(i, j, map[i][j], d)) {
                            System.out.println(map[i][j]);
                            // Adjust starting position based on direction
                            if (d == 3) { // Diagonal left down correction
                                int start_i = i - dx[d] * 4;
                                int start_j = j - dy[d] * 4;
                                System.out.println((start_i + 1) + " " + (start_j + 1));
                            } else {
                                System.out.println((i + 1) + " " + (j + 1));
                            }
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean win(int x, int y, int target, int dir) {
        int count = 1;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // Forward check
        while (isValid(nx, ny) && map[nx][ny] == target) {
            count++;
            nx += dx[dir];
            ny += dy[dir];
        }

        // Backward check (only for lines of exactly five)
        if (count == 5) {
            nx = x - dx[dir];
            ny = y - dy[dir];
            if (isValid(nx, ny) && map[nx][ny] == target) {
                return false;
            }

            nx = x + dx[dir] * 5;
            ny = y + dy[dir] * 5;
            if (isValid(nx, ny) && map[nx][ny] == target) {
                return false;
            }
            return true;
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }
}
