import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> ns = new ArrayList<String>();
        List<String> ms = new ArrayList<String>();
        for(int i = 0; i < n; i++){
            ns.add(sc.nextLine());
        }
        for(int i = 0; i < m; i++){
            ms.add(sc.nextLine());
        }
        int count = 0;
        for(String s : ms){
            if(ns.contains(s)){
                count++;
            }
        }
        System.out.println(count);


    }
}
