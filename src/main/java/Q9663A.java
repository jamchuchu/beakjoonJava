import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q9663A {

    static int num;
    static boolean[] vList;
    static int[] select;
    static List<int[]> list;

    static int[][] v;
    static int count;
    static int[] dx ;
    static int[] dy ;

    static Scanner sc;

    public static void main(String[] args){
        sc = new Scanner(System.in);

        num = sc.nextInt();

        vList = new boolean[num];
        select = new int[num];

        list = new ArrayList<>();


        selectList(0); // 후보군 list

        v =  new int[num][num];


        for(int i = 0; i < list.size(); i++){
            test(list.get(i));
        }

        System.out.println(count);

    }

    static void selectList(int depth){
        if(depth == num){
            int[] temp = new int[num];
            for(int i=0; i<temp.length; i++){
                temp[i] = select[i];
            }
            list.add(temp);
            return;
        }


        for(int i = 0; i < num; i++){
            if(!vList[i]){
                vList[i] = true;
                select[depth] = i;

                selectList(depth+1);
                vList[i] = false;
            }
        }
    }

    static void test(int[] select) {
        v = new int[num][num];
        for (int m = 0; m < select.length-1; m++) {
            int i = m;
            int j = select[m];
            if (v[i][j] == 0) {
                for (int k = 0; k < num; k++) { //queen effect

                    dx = new int[]{i, i, i + k, i + k, i + k, i - k, i - k, i - k};
                    dy = new int[]{j + k, j - k, j + k, j, j - k, j + k, j, j - k};

                    for (int l = 0; l < 8; l++) {
                        if (dx[l] != 8 && dy[l] != 8 && -1 < dx[l] && dx[l] < num && -1 < dy[l] && dy[l] < num) {
                            v[dx[l]][dy[l]] = 1;
                        }
                    }
                    v[i][j] = 8; // queen posi

                }
//            print(v);
            }else{
                return;
            }
        }
//
//        System.out.println(select.length-1 +" " + select[select.length-1]);
//        sc.nextLine();
//        print(select);
//        print(v);
//        System.out.println();

        if(v[select.length-1][select[select.length-1]] == 0){
            print(v);
            count++;
        }

    }



    static void print(int[] posi){
        for(int i=0; i < posi.length; i++){
            System.out.print(posi[i]+ " ");
        }
        System.out.println();
    }

    static void print(int[][] posi){
        for(int i=0; i<num; i++) {
            for (int j = 0; j <num; j++) {
                System.out.print(posi[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}