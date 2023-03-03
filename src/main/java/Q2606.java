import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q2606 {
    static boolean[] v;
    static ArrayList<Integer>[] list;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int line = sc.nextInt();
        v = new boolean[num+1];
        list = new ArrayList[num+1];
        for(int i =0; i<num+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0; i<line; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        int count = 0;

        for(int i =1; i< num+1; i++){
            if(v[i]){
                count++;
            }
        }

        System.out.println(count-1);
    }

    static void dfs(int num){
        v[num] = true;
        if(list[num].size() == 0){
            return;
        }
        for(int i = 0; i< list[num].size(); i++) {
            if (!v[ list[num].get(i)]) {
                dfs( list[num].get(i));
            }
        }

    }
}
