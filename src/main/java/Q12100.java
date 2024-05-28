import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q12100 {
    static int n, answer;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] list = new int[5];
        Arrays.fill(list, -1);
//        move(0, map);
        dfs(4,0, list);

        System.out.println(answer);
    }

    static void dfs(int max, int depth, int[] list){
        if(5 == depth){
            print(list);
            int[][] newMap = clone(map);
            for(int i = 0; i < 5 ; i++){
                move(list[i] , clone(newMap));
            }
            return;
        }
        for(int i = 0; i < max; i++){
            list[depth] = i;
            dfs(max, depth+1, list);
            list[depth] = -1;
        }
    }

    static void print(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    static void print(int[][] map){
        for(int i = 0; i < n; i++){
            print(map[i]);
        }
        System.out.println();
    }

    static int[][] clone(int[][] map){
        int[][] newMap = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    /*
    * 1. 방향을 param으로 받아서 방향에 따라 줄단위로 다시 쪼갠다
    * 2. 방향 반대쪽 부터 둘씩 꺼내어 둘이 같을 때는 변화 후 Que가 좋을 듯 하다
    * 다음 두개를 꺼내서 확인 1,2/ 3,4
    * 둘이 다를때는 다음 하나를 꺼내서  1,2/ 2,3
    * que가 비면 다시 입력
    *
    * 0,1,2,3 오, 왼, 위, 아래
    * */

    static void move(int dir, int[][] map){
        switch (dir){
            case 0 :
                for(int i = 0 ; i < n; i++){
                    Deque<Integer> deq = new LinkedList<>(Arrays.asList(
                            Arrays.stream(map[i]).boxed().toArray(Integer[]::new)
                    ));
                    Arrays.fill(map[i] , 0);
                    int j = n-1;
                    while(deq.size() > 1){
                        int a = deq.pollLast();
                        int b = deq.pollLast();
                        if(a == 0 && b == 0){
                            continue;
                        }else if(a == 0){
                            deq.addLast(b);
                            continue;
                        }else if(b == 0){
                            deq.addLast(a);
                            continue;
                        }

                        if(a == b){
                            map[i][j] = a + b;
                            answer = Math.max(answer, map[i][j]);
                        }else{
                            map[i][j] = a;
                            deq.addLast(b);
                            answer = Math.max(answer, map[i][j]);
                        }
                        j--;
                    }
                    if(deq.size() == 1){
                        map[i][j] = deq.poll();
                        answer = Math.max(answer, map[i][j]);
                    }
                }
                print(map);
                break;
            case 1 :
                for(int i = 0 ; i < n; i++){
                    Deque<Integer> deq = new LinkedList<>(Arrays.asList(
                            Arrays.stream(map[i]).boxed().toArray(Integer[]::new)
                    ));
                    Arrays.fill(map[i] , 0);

                    int j = 0;
                    while(deq.size() > 1){
                        int a = deq.pollFirst();
                        int b = deq.pollFirst();
                        if(a == 0 && b == 0){
                            continue;
                        }else if(a == 0){
                            deq.addFirst(b);
                            continue;
                        }else if(b == 0){
                            deq.addFirst(a);
                            continue;
                        }

                        if(a == b){
                            map[i][j] = a + b;
                            answer = Math.max(answer, map[i][j]);
                        }else{
                            map[i][j] = a;
                            deq.addFirst(b);
                            answer = Math.max(answer, map[i][j]);
                        }
                        j++;
                    }
                    if(deq.size() == 1){
                        map[i][j] = deq.poll();
                        answer = Math.max(answer, map[i][j]);
                    }
                }
                print(map);
                break;
            case 2 : //  up
                for(int i = 0 ; i < n; i++){
                    Deque<Integer> deq = new LinkedList<>();
                    for(int j = 0 ; j < n; j++){
                        deq.add(map[j][i]);
                        map[i][j] = 0;
                    }

                    int j = 0;
                    while(deq.size() > 1){
                        int a = deq.pollFirst();
                        int b = deq.pollFirst();
                        if(a == 0 && b == 0){
                            continue;
                        }else if(a == 0){
                            deq.addFirst(b);
                            continue;
                        }else if(b == 0){
                            deq.addFirst(a);
                            continue;
                        }

                        if(a == b){
                            map[i][j] = a + b;
                            answer = Math.max(answer, map[i][j]);
                        }else{
                            map[i][j] = a;
                            deq.addFirst(b);
                            answer = Math.max(answer, map[i][j]);
                        }
                        j++;
                    }
                    if(deq.size() == 1){
                        map[i][j] = deq.poll();
                        answer = Math.max(answer, map[i][j]);
                    }
                }
                break;
            case 3:
                for(int i = 0 ; i < n; i++){
                    Deque<Integer> deq = new LinkedList<>();
                    for(int j = 0 ; j < n; j++){
                        deq.add(map[j][i]);
                        map[i][j] = 0;
                    }
                    int j = n-1;
                    while(deq.size() > 1){
                        int a = deq.pollLast();
                        int b = deq.pollLast();
                        if(a == 0 && b == 0){
                            continue;
                        }else if(a == 0){
                            deq.addLast(b);
                            continue;
                        }else if(b == 0){
                            deq.addLast(a);
                            continue;
                        }
                        if(a == b){
                            map[i][j] = a + b;
                            answer = Math.max(answer, map[i][j]);
                        }else{
                            map[i][j] = a;
                            deq.addLast(b);
                            answer = Math.max(answer, map[i][j]);
                        }
                        j--;
                    }
                    if(deq.size() == 1){
                        map[i][j] = deq.poll();
                        answer = Math.max(answer, map[i][j]);
                    }
                }
                break;
        }
    }
}
