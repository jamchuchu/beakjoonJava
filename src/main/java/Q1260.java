import java.util.ArrayList;
import java.util.Scanner;

public class Q1260 {
    static ArrayList<Integer>[] list;
    static boolean[] v;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();

        list = new ArrayList[num+1];
        v =  new boolean[num+1];
        for(int i  = 0; i< num+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i  = 0; i< line; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        dfs(start);

        System.out.println("=====");

        bfs(start, num);
    }

    static void dfs(int num){
        if(list[num].size() == 0){
            return;
        }
        v[num] = true;
        for(int i = 0; i < list[num].size(); i++ ){
            if(!v[list[num].get(i)]){
                System.out.print(list[num].get(i) + " ");
                dfs(list[num].get(i));
            }
        }
    }

    static void bfs(int num, int target){
        v[num] = true;
        for(int j =0;  j < list[num].size(); j++){
                if(!v[list[num].get(j)]){
                    System.out.print(list[num].get(j) + " ");
                    bfs(num+1, target);
                }
            }
        }


}
