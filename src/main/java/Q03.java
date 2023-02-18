import java.util.*;

public class Q03 {

    static int row = 0;
    static int col = 0;
    static String dir = "R";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int mapSize = sc.nextInt();

        boolean[][] map = new boolean[mapSize][mapSize];
        boolean[][] apple = new boolean[mapSize][mapSize];
        int appleNum =  sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < appleNum; i++){
            String appleMove = sc.nextLine();
            String[] appleMoveLine = appleMove.split(" ");
            int appRow = Integer.parseInt(appleMoveLine[0])-1;
            int appCol = Integer.parseInt(appleMoveLine[1])-1;
            apple[appRow][appCol] = true;
        }
        //뱀 자신의몸 위치 정보
        Deque<int[]> snake = new LinkedList<>();
        snake.addFirst(new int[]{0,0});

        //start 시 위치
        map[row][col] = true;
        int time = 0;
        int tryNum = sc.nextInt();
        sc.nextLine();

        String move = sc.nextLine();
        String[] moveLine = move.split(" ");
        int moveTime = Integer.parseInt(moveLine[0]);
        String inputMoveDir = moveLine[1];
        int realtry = 0;


        while(true){
                move(dir);
                try {
                    if(!map[row][col]){
                        map[row][col] = true; //머리 이동
                    }else{
                        throw new Exception("touch");
                    }
                    snake.addFirst(new int[]{row, col});
                    if (!apple[row][col]) {//사과 없으면

                        int[] tail = snake.removeLast();//꼬리이동
                        map[tail[0]][tail[1]] = false;
                    }else {
                        apple[row][col] = false;
                    }
                } catch (Exception e) {
                    time++;
                    System.out.println(time);
                    break;
                }
                time++;

                if(time == moveTime){
                    dir = rotate(inputMoveDir);
                    realtry++;

                    if(tryNum > realtry){
                        move = sc.nextLine();
                        moveLine = move.split(" ");
                        moveTime = Integer.parseInt(moveLine[0]);
                        inputMoveDir = moveLine[1];
                    }
                }
            }
    }



    static public void move(String dir){
        if(dir.equals("R")){
            col++;
        }else if(dir.equals("D")){
            row++;
        }else if(dir.equals("L")){
            col--;
        }else if(dir.equals("U")){
            row--;
        }
    }
    static public String rotate(String moveDir){
        if(dir.equals("R")){
            if(moveDir.equals("D")){
                moveDir = "D";
            }else{
                moveDir = "U";
            }
        }else if(dir.equals("D")){
            if(moveDir.equals("D")){
                moveDir = "L";
            }else{
                moveDir = "R";
            }
        }else if(dir.equals("L")){
            if(moveDir.equals("D")){
                moveDir = "U";
            }else{
                moveDir = "D";
            }
        }else if(dir.equals("U")){
            if(moveDir.equals("D")){
                moveDir = "R";
            }else{
                moveDir = "L";
            }
        }
        return moveDir;
    }

    static void printMap(boolean[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static public void printSnake(Deque<int[]> snake){
        snake.forEach(body -> {
            System.out.print("["+ body[0] + ", " + body[1] + " ], ");
        });
        System.out.println();
    }}
