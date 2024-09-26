import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
* 가장 간단한 방법 map 하나하나 list를 다 넣는다 :  메모리 초과 예상
* 12*12*10*4(int)  -> 안남
*
* 색깔 맵
* 체스 맵
*
* 1. 들어오는 순으로 입장 //  메모리 상 3차 배열로
* 2. 이동 조정
*
* 하양 이동 -- 정방향
* 빨강 이동 -- 순서 변환 후 정방향
* 파랑 이동 -- 역방향
*
* 이동 (list)
* 역방향 이동(list)
*
* */

public class Q17837 {
    static class Chess {
        int x, y, z, dir;

        public Chess(int x, int y, int z, int dir) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dir = dir;
        }
    }

    static boolean isMoreThan4 = false;
    static int answer, n, k, time;
    static int[] dx = new int[]{0, 0, 0, -1, 1};
    static int[] dy = new int[]{0, 1, -1, 0, 0};
    static int[][] map;
    static int[][][] chessMap;

    static List<Chess> chessList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(str[j - 1]);
            }
        }

        //0번 체스 --1번 부터 시작
        chessList.add(new Chess(0, 0, 0, 0));

        chessMap = new int[n + 1][n + 1][k];

        for (int i = 1; i <= k; i++) {

            str = reader.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int dir = Integer.parseInt(str[2]);

            int z = countMap(x, y);
            chessMap[x][y][z] = i;

            chessList.add(new Chess(x, y, z, dir));
        }

        while (!isMoreThan4) {
            answer++;
            for (int i = 1; i <= k; i++) {
                move(i);
            }
            if (isMoreThan4) {
                break;
            }
            if (answer > 1000) {
                answer = -1;
                break;
            }
        }


        writer.write(answer + " ");
        writer.flush();
        writer.close();
    }

    static void move(int num) { // 0. white 1. red 2. blue
        Chess ch = chessList.get(num);
        int moveX = ch.x + dx[ch.dir];
        int moveY = ch.y + dy[ch.dir];

        if (moveX <= 0 || moveY <= 0 || moveX > n || moveY > n) {
            ch.dir = reverseDir(ch.dir);
            moveX = ch.x + dx[ch.dir];
            moveY = ch.y + dy[ch.dir];
        } else if (map[moveX][moveY] == 2) {
            ch.dir = reverseDir(ch.dir);
            moveX = ch.x + dx[ch.dir];
            moveY = ch.y + dy[ch.dir];
            if (moveX <= 0 || moveY <= 0 || moveX > n || moveY > n) {
                ch.dir = reverseDir(ch.dir);
                moveX = ch.x + dx[ch.dir];
                moveY = ch.y + dy[ch.dir];
            }
        }

        int color = map[moveX][moveY];

        if (color == 2) {
            return;
        }
        ArrayDeque<Integer> blocks = removeBlocks(ch.x, ch.y, ch.z);
        if (color == 0) {
            moveBlocks(blocks, moveX, moveY, 0);
        }
        if (color == 1) {
            moveBlocks(blocks, moveX, moveY, 1);
        }

    }


    static ArrayDeque<Integer> removeBlocks(int x, int y, int floor) {
        ArrayDeque<Integer> blocks = new ArrayDeque<>();
        for (int i = floor; i < k; i++) {
            int num = chessMap[x][y][i];
            if (num == 0) {
                break;
            } else {
                chessMap[x][y][i] = 0;
                blocks.add(num);
            }
        }
        return blocks;
    }

    static void moveBlocks(ArrayDeque<Integer> blocks, int x, int y, int dir) {
        int emptyFloor = countMap(x, y);

        while (!blocks.isEmpty()) {
            int num = -1;
            if (dir == 0) {
                num = blocks.poll();
            }
            if (dir == 1) {
                num = blocks.pollLast();
            }
            chessMap[x][y][emptyFloor] = num;

            // 위치 좌표 수정
            chessList.get(num).x = x;
            chessList.get(num).y = y;
            chessList.get(num).z = emptyFloor;

            emptyFloor++;

            if (emptyFloor >= 4) {
                isMoreThan4 = true;
                return;
            }
        }
    }


    //시간 초과 나면 0층에 입력 예정
    static int countMap(int x, int y) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (chessMap[x][y][i] == 0) {
                count = i;
                break;
            }
        }
        return count;
    }


    static int reverseDir(int origin) {
        int answer = 0;
        if (origin == 1) {
            answer = 2;
        }
        if (origin == 2) {
            answer = 1;
        }
        if (origin == 3) {
            answer = 4;
        }
        if (origin == 4) {
            answer = 3;
        }
        return answer;
    }

}


