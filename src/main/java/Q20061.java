import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q20061 {
    static int n, score, count,answer;
    static int[][] mapG;
    static int[][] mapB;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        mapG = new int[6][4];
        mapB = new int[6][4];


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
            blockDown(setBlock(t,x,y,1), 1);
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


    static void print(int[][] map){
        for(int o = 0 ; o< map.length ; o++){
            for(int p = 0 ; p< map[o].length ; p++){
                System.out.print(map[o][p] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static int findHeight(List<int[]> blocks, int color){
        if(blocks.size() == 1) {
            return height(blocks.get(0)[1], color);
        }else{
            if(blocks.get(0)[1] == blocks.get(1)[1]){
                return height(blocks.get(0)[1], color);
            }else{
                return Math.min(height(blocks.get(0)[1], color), height(blocks.get(1)[1], color));
            }
        }
    }

    static int height(int j, int color){
        int height = 6;
        if (color == 0) {//g
            for (int i = 5; i >= 0; i--) {
                if (mapG[i][j] == 1) {
                    height = i;
                }
            }
        } else {//b
            for (int i = 5; i >= 0; i--) {
                if (mapB[i][j] == 1) {
                    height = i;
                }
            }
        }
        return height;
    }

    //blockDown
    static void blockDown(List<int[]> blocks, int color){// g or b
        int height = findHeight(blocks, color);

        if(color == 0){//g
            for(int[] b: blocks){
                mapG[height - b[0]][b[1]] = 1;
            }
        }else{//b
            for(int[] b: blocks){
                mapB[height - b[0]][b[1]] = 1;
            }
        }
    }
    //isFull
    static boolean isFull(int i , int color){//g or b
        if(color == 0){
            for(int j = 0 ; j < 4; j++){
                if(mapG[i][j] == 0){
                    return false;
                }
            }
            return true;
        }else{
            for(int j = 0 ; j < 4; j++){
                if(mapB[i][j] == 0){
                    return false;
                }
            }
            return true;
        }
    }

    static boolean isIn(int i , int color){//g or b
        if(color == 0){
            for(int j = 0 ; j < 4; j++){
                if(mapG[i][j] == 1){
                    return true;
                }
            }
        }else{
            for(int j = 0 ; j < 4; j++){
                if(mapB[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    //remove
    static void mapDown(int i, int color){//g or b
        if(color == 0){
            Arrays.fill(mapG[i], 0);
            for(int x = i; x > 0 ; x--){
                for(int y = 0 ; y< 4; y++){
                    mapG[x][y] = mapG[x-1][y];
                }
            }
            Arrays.fill(mapG[0], 0);
        }else{
            Arrays.fill(mapB[i], 0);
            for(int x = i; x > 0 ; x--){
                for(int y = 0 ; y< 4; y++){
                    mapB[x][y] = mapB[x-1][y];
                }
            }
            Arrays.fill(mapB[0], 0);
        }
    }


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
                if(mapG[i][j] == 1){
                    count++;
                }
                if(mapB[i][j] == 1){
                    count++;
                }
            }
        }
    }


}
