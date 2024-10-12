import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q20061A {
    static int n, score, count,answer;
    static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[2][6][4];


        n = Integer.parseInt(reader.readLine());
        for(int k = 0 ; k< n; k++){
            String[] str = reader.readLine().split(" ");
            int t = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);
            //G
            blockDown(setBlock(t,x,y,0), 0);
            for(int i = 2 ; i< 6 ; i++){
                if(isFull(i, 0)){
                    mapDown(i, 0);
                    score++;
                }
            }
            for(int i = 0 ; i< 2 ; i++){
                if(isIn(1, 0)){
                    mapDown(5, 0);
                }
            }

            //B
            blockDown(setBlock(t,x,y, 1), 1);
            for(int i = 2 ; i< 6 ; i++){
                if(isFull(i, 1)){
                    mapDown(i, 1);
                    score++;
                }
            }
            for(int i = 0 ; i< 2 ; i++){
                if(isIn(1, 1)){
                    mapDown(5, 1);
                }
            }
        }
        countMapBlock();

        writer.write(score+"\n");
        writer.write(count+"\n");
        writer.flush();
        writer.close();
    }



    // 최대 높이 탐색, 단 가로로 길 경우 둘중에 높은것을 최대 높이로 return
    static int findHeight(List<int[]> blocks, int color){
        if(blocks.size() == 1) {
            return height(blocks.get(0)[1], color);
        }else{
            if(blocks.get(0)[1] == blocks.get(1)[1]){
                return height(blocks.get(0)[1], color);
            }else{// 가로 2칸
                return Math.min(height(blocks.get(0)[1], color), height(blocks.get(1)[1], color));
            }
        }
    }

    //가로가 정해져있?을때 최대 높이
    static int height(int j, int color){
        int height = 6;
        for (int i = 5; i >= 0; i--) {
            if (map[color][i][j] == 1) {
                height = i;
            }
        }
        return height;
    }

    // 가로는 가만히 세로만 최대 높이 +1
    //blockDown
    static void blockDown(List<int[]> blocks, int color){// g or b
        int height = findHeight(blocks, color);
         for(int[] b: blocks){
                map[color][height - b[0]][b[1]] = 1;
        }
    }

    //해당 행이 다 찼는지
    //isFull
    static boolean isFull(int i , int color){//g or b
        for(int j = 0 ; j < 4; j++){
            if(map[color][i][j] == 0){
                return false;
            }
        }
        return true;
    }

    //1,2열에 행이 하나라도 차있는지
    static boolean isIn(int i , int color){//g or b
        for(int j = 0 ; j < 4; j++){
            if(map[color][i][j] == 1){
                return true;
            }
        }
        return false;
    }

    //한칸 제거 후 위칸들 끌어 당기기
    //remove
    static void mapDown(int i, int color){//g or b
        Arrays.fill(map[color][i], 0);
        for(int x = i; x > 0 ; x--){
            for(int y = 0 ; y< 4; y++){
                map[color][x][y] = map[color][x-1][y];
            }
        }
        Arrays.fill(map[color][0], 0);
    }


    //색깔따라 가로 세로 블럭 돌려서 제작 후 리턴
    static List<int[]> setBlock(int t, int x, int y, int color){//g b
        List<int[]> block = new ArrayList<>();
        if(color == 0){
            if(t == 1){
                block.add(new int[]{1, y});
            }else if(t == 2){
                block.add(new int[]{1, y});
                block.add(new int[]{1, y+1});
            }else if(t == 3){
                block.add(new int[]{1, y});
                block.add(new int[]{2, y});
            }
        }else{
            if(t == 1){
                block.add(new int[]{1, 3-x});
            }else if(t == 2){
                block.add(new int[]{1, 3-x});
                block.add(new int[]{2, 3-x});
            }else if(t == 3){
                block.add(new int[]{1, 3-x});
                block.add(new int[]{1, 3-(x+1)});
            }
        }
        return block;
    }

    static void countMapBlock(){
        for(int i = 0; i < 6 ; i++){
            for(int j = 0; j < 4; j++){
                if(map[0][i][j] == 1){
                    count++;
                }
                if(map[1][i][j] == 1){
                    count++;
                }
            }
        }
    }


}
