import java.io.*;

public class Q1063 {
    /*
    *
    * 	14352	132
    * */
    static int[] dx = {0,0,-1,1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int x, y, rx, ry, n;
    static StringBuilder king, rock;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        y = str[0].charAt(0)-64;
        x = str[0].charAt(1)-48;
        ry = str[1].charAt(0)-64;
        rx = str[1].charAt(1)-48;
        n = Integer.parseInt(str[2]);


        for(int i=0; i<n; i++) {
            int dir = getMoveIdx(reader.readLine());
            int[] afterMove = move(dir ,x , y);
            x = afterMove[0];
            y = afterMove[1];
            if (x == rx && y == ry) {// 같을때
                if(check(rx, ry, dir)){// 돌 움직 가능
                    afterMove = move(dir ,rx , ry);
                    rx = afterMove[0];
                    ry = afterMove[1];
                }else{// 돌 움직 불가 시 제자리
                    afterMove = returnMove(dir ,x , y);
                    x = afterMove[0];
                    y = afterMove[1];
                }
            }
        }


        king = new StringBuilder();
        rock = new StringBuilder();
        king.append((char)((char)(y + 16)+ '0'));
        king.append(x);
        writer.write(king.toString() + "\n");
        rock.append((char)((char)(ry + 16)+ '0'));
        rock.append(rx);
        writer.write(rock.toString() + "\n");


        writer.flush();
        writer.close();
    }

    static int[] move(int idx, int x, int y){
        if(check(x , y, idx)) {
            x += dx[idx]; y += dy[idx];
        };
        return new int[]{x, y};
    }

    static int[] returnMove(int idx, int x, int y){
        x -= dx[idx]; y -= dy[idx];
        return new int[]{x, y};
    }


    static boolean check(int x, int y, int i){
        if(x + dx[i] < 1 || y + dy[i] < 1 || x + dx[i] > 8 || y + dy[i] > 8){
            return false;
        }
        return true;
    }

    static int getMoveIdx(String dir){
        if(dir.equals("R")){
            return 0;
        }else if(dir.equals("L")){
            return 1;
        }else if(dir.equals("B")){
            return 2;
        }else if(dir.equals("T")){
            return 3;
        }else if(dir.equals("RT")){
            return 4;
        }else if(dir.equals("LT")){
            return 5;
        }else if(dir.equals("RB")){
            return 6;
        }else if(dir.equals("LB")){
            return 7;
        }
        return 9;
    }

}
