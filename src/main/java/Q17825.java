import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q17825 {

    /*
    *
    * class Space 만들어서 점수와 다음칸(1,2,3,4,5) 배치
    * dfs
    *
    * 도착에 가면 stop
    *
    * 현재 말 상태, total 점수를 가지고 있는 map
    *
    * */


    static class Piece{
        int page, space;

        public Piece(int page, int space) {
            this.page = page;
            this.space = space;
        }

    }

    static int totalScore, answer;
    static int[] mapRound = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40};
    static int[] mapLeft = {0,13,16,19};
    static int[] mapDown = {0,22,24};
    static int[] mapRight = {0,28,27,26};
    static int[] mapUp = {25,30,35};

    static List<Piece> pieces = new ArrayList<>();
    static List<int[]> map = new ArrayList<>();

    static int[] turn;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        map.add(mapRound);
        map.add(mapLeft);
        map.add(mapDown);
        map.add(mapRight);
        map.add(mapUp);

        pieces.add(new Piece(0,0));
        pieces.add(new Piece(0,0));
        pieces.add(new Piece(0,0));
        pieces.add(new Piece(0,0));

        turn = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0,0);

        while(true){
            if(pieces.get(0).page == -1){
                break;
            }
            play(0, 1);
        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }


    static boolean isOccupied(Piece newPiece, int thisTime) {
        if(newPiece.page == -1){
            return false;
        }
        for (int i = 0 ; i < 4; i++) {
            Piece p = pieces.get(i);
            if(p.page == -1){
                continue;
            }
            if(i == thisTime){
                continue;
            }
            if(newPiece.page == p.page && newPiece.space == p.space){
                return true;
            }
        }
        return false;
    }

    static Piece play(int idx, int time){
        Piece piece = new Piece(pieces.get(idx).page, pieces.get(idx).space);

        if(piece.page == 0) {
            if (piece.space ==5 ||piece.space == 10||piece.space==15){
                piece.page =  piece.space / 5;
                piece.space = 0;
            }
        }
        piece.space += time;

        if(piece.space >= map.get(piece.page).length){
            if(piece.page == 0){
                piece.page = -1;
                piece.space = -1;
            }
            if(piece.page == 1 || piece.page == 2 || piece.page == 3){
                piece.space -= map.get(piece.page).length;
                piece.page = 4;
            }
            if(piece.page == 4){
                if(piece.space - map.get(piece.page).length == 0){
                    piece.space = 20;
                    piece.page = 0;
                }else if(piece.space - map.get(piece.page).length > 0){
                    piece.page = -1;
                    piece.space = -1;
                }
            }
        }

        return piece;
    }

    static void dfs(int turnNum, int score){
        if(turnNum == 10){
            answer = Math.max(answer, score);
            return;
        }

        for(int i = 0 ; i < 4; i++){
            Piece originP = pieces.get(i);
            if(originP.space == -1 && originP.page == -1){
                continue;
            }

            Piece p = play(i, turn[turnNum]);
            if (isOccupied(p, i)) {
                continue;
            }

            int plusScore = 0;
            if(p.page != -1){ //새로 움직인 말이 골인 하면 0
                plusScore = map.get(p.page)[p.space];
            }

            pieces.set(i, p);
            dfs(turnNum+1, score + plusScore);
            pieces.set(i, originP);

            //5 4 5 2 2 2 5 3 1 4
        }

    }


}
