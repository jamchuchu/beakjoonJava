import java.io.*;
import java.util.*;

public class Q17142 {

    /*
    * 바이러스 활성, 비활성
    * 상화좌우 복제
    *
    * 0, 빈칸, 1-벽 2-바이러스
    *
    * 일반 bfs 아님?
    *
    * 처음 부터 개수 카운트 해서
    * 변화 없으면 -1
    * 완료 카운트 찾으면 종료
    *
    * 어차피 비활성 바이러스는 활성 바이러스를 만나야 활성이 되는데
    * 그게 의미가 잇나?
    * 마지막으로 활성 바이러스 남겨놓으면 시간 1초 줄 일 수 있음
    * 비활성 바이러스도 바이러스임
    *
    * */

    static int answer, n, m, target;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static int[][] map;
    static boolean[][] visit;
    static List<int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][n];
        visit = new boolean[n][n];
        answer  = Integer.MAX_VALUE;

        for(int i = 0 ; i< n; i++){
            str = reader.readLine().split(" ");
            for(int j = 0 ; j< n; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 2){// 비활성 바이러스 리스트
                    virus.add(new int[]{i, j});
                }
            }
        }

        dfs(virus.size(), m, 0, 0, new int[m]);


        writer.write(answer == Integer.MAX_VALUE ? -1 + " " : answer + " ");
        writer.flush();
        writer.close();
    }

    //비활성 바이러스중 m 개 선택해서 활성으로 변경
    static void dfs(int totalVirusCount, int m, int depth, int num,  int[] aliveVirusNum){
        if(depth == m){
            int[][] newMap = new int[n][n];
            int targetCount = 0;
            // map copy 한바퀴
            for(int i = 0 ; i< n; i++){
                for(int j = 0 ; j < n; j++){
                    newMap[i][j] = map[i][j] - 2; // 벽은 -1, 빈칸은 -2, 비활성은 0
                    if(newMap[i][j] == -1){
                        visit[i][j] = true;
                    }else{
                        visit[i][j] = false;
                    }
                    if(newMap[i][j] == -2){ //빈칸일 때만 카운트 up
                        targetCount++;
                    }
                }
            }
            if(targetCount == 0){
                answer = 0;
                return;
            }
            bfs(aliveVirusNum , targetCount, newMap);
            return;
        }
        for(int i = num ; i < totalVirusCount; i++){
            aliveVirusNum[depth] = i;
            dfs(totalVirusCount, m, depth+1, i+1, aliveVirusNum);
        }
    }

    // 활성 바이러스로 퍼짐
    static void bfs(int[] virusNum, int targetCount, int[][] map){//활성화 바이러스
        Queue<int[]> que = new LinkedList<>();
        for(int num : virusNum){ //  활성 바이러스 방문 처리
            int x = virus.get(num)[0];
            int y = virus.get(num)[1];
            visit[x][y] = true;
            que.add(new int[]{x, y});
        }
        int time = 0;

        while(!que.isEmpty()){
            int[] pre = que.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nowX = pre[0] + dx[i];
                int nowY = pre[1] + dy[i];
                if(nowX< 0 || nowY < 0 || nowX >= n ||nowY >= n){
                    continue;
                }
                if(visit[nowX][nowY]){
                    continue;
                }
                visit[nowX][nowY] = true;
                if(map[nowX][nowY] == -2){// 빈칸에 새로 채운 경우만
                    targetCount--;
                }


                map[nowX][nowY] = map[pre[0]][pre[1]]+1;
                time = Math.max(map[nowX][nowY], time);
                que.add(new int[]{nowX, nowY});

                if(targetCount == 0){
                    break;
                }
            }

            if(targetCount == 0){
                break;
            }
        }

        if(targetCount == 0){
            answer = Math.min(answer, time);
        }

    }

}
