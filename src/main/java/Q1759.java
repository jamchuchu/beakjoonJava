import java.util.*;

public class Q1759 {
    static int a;
    static int b;
    static List<String> list;
    static String[] select;
    static List<String> aeiou = new ArrayList<>(Arrays.asList(new String[]{"a", "e","i","o","u"}));
    static boolean[] v;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();

        list = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        select =  new String[a];
        v =  new boolean[b];

        Collections.sort(list);

        dfs(0);
    }

    static void dfs(int depth){
        if(depth == a){
            int c = 0;
            int d = 0;
            for(int i=0;i < a; i++){
                if(aeiou.contains(select[i])){
                    c++;
                }else{
                    d++;
                }
            }
            if(c != 0 && d > 1) {
                for (int i = 0; i < a; i++) {
                    System.out.print(select[i]);
                }
                System.out.println();
            }
            return;
        }
        for(int i= 0; i< b; i++){
            if(!v[i]){
                v[i] = true;
                if(depth == 0){
                    select[depth] = list.get(i);
                    dfs(depth+1);
                }else {
                    if (select[depth - 1].hashCode() < list.get(i).hashCode()) {
                        select[depth] = list.get(i);
                        dfs(depth + 1);
                    }
                }
                v[i] = false;

            }
        }

    }
}
