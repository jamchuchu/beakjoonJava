import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q1079 {

    static int answer, n, m, person, count;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(reader.readLine());
        person = n;
        int[] guilty = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[n][n];
        for(int i = 0; i < n ; i++){
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        m =Integer.parseInt(reader.readLine());

        ArrayDeque<int[]> deq = new ArrayDeque<>();
        deq.add(guilty);

        while(true){
            int size = deq.size();
            if(size == 0)break;

            if(n % 2 == 0){// 밤

                for(int i = 0 ; i< size; i++){
                    int[] now = deq.poll();

                    for(int j = 0 ; j< n; j++){
                        System.out.print(now[j] + " ");
                    }
                    System.out.print( "-> ");

                    for(int j = 0 ; j< n; j++) {
                        if (j == m) continue;
                        if (now[j] == 0) continue;

                        try {
                            deq.add(night(j, now.clone()));
                        }catch (Exception e){
                            break;
                        }
                    }

                    int[] temp = deq.peekLast();
                    for(int j = 0 ; j< n; j++){
                        System.out.print(temp[j] + " ");
                    }
                    System.out.println();
                }
                count++;
            }else{//낮
                for(int i = 0 ; i< size; i++){
                    int[] now = deq.poll();
                    for(int j = 0 ; j< n; j++){
                        System.out.print(now[j] + " ");
                    }
                    System.out.print( "-> ");
                    try {
                        deq.add(afternoon(now.clone()));
                        int[] temp = deq.peekLast();
                        for(int j = 0 ; j< n; j++){
                            System.out.print(temp[j] + " ");
                        }
                        System.out.println();
                    }catch (Exception e){
                        continue;
                    }
                }
            }
        }


        writer.write( count +" ");
        writer.flush();
        writer.close();
    }

    static int[] afternoon(int[] guilty) { // 점수 제일 높고 번호 제일 빠른 사람
        int maxIdx = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (guilty[i] == 0) { // 죽음
                continue;
            }
            if (max < guilty[i]) {
                maxIdx = i;
                max = guilty[i];
            }
        }
        if (maxIdx == -1 || maxIdx == m) {
            return null;
        }

        int[] answer = guilty.clone();
        answer[maxIdx] = 0; // 죽은 사람 표시

        if(isGameContinue(answer)) return answer;
        else return null;
    }


    static int[] night(int deathIdx,int[] guilty){// 죽이기
        guilty[deathIdx] = 0;
        int[] answer = guilty.clone();

        //나머지 guilty up
        for(int i = 0; i< n; i++){
            if(answer[i] == 0){
                continue;
            }
            answer[i] += map[deathIdx][i];
        }

        if(isGameContinue(answer)) return answer;
        else return null;
    }

    static boolean isGameContinue(int[] guilty){
        boolean flag = false;
        for(int i = 0 ; i< n; i++){
            if(guilty[i] != 0 && i != m)flag = true;
        }
        return flag;
    }

}
