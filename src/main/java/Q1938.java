import java.util.Scanner;

public class Q1938 {
    static int num;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        num = sc.nextInt();
        map = new int[num][num];
        sc.nextLine();

        for(int i =0; i< num; i++){
            String[] str = sc.nextLine().split(" ");
            for(int j =0; j<num; j++){
                if(str[j].equals("B")){// 현재
                    map[i][j] = 2;
                }else if(str[j].equals("0")){
                    map[i][j] = 0;
                }else if(str[j].equals("1")){ // 나무 없다
                    map[i][j] = 1;
                }else if(str[j].equals("E")){ // 도착
                    map[i][j] = 9;
                }
            }
        }
    }
}
