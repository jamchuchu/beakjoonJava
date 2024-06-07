import java.io.*;
import java.util.*;

public class Q21939A {
    /*
     * 시간 초과 나면 map
     * */


    static int n, m;
    static TreeSet<Quiz> set = new TreeSet<>((o1, o2) ->{
        if(o1.diff == o2.diff) return o1.num -  o2.num;
        return o1.diff - o2.diff;
    });// num diff

    static class Quiz{
        int num;
        int diff;

        public Quiz(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }
    }

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            String[] str = reader.readLine().split(" ");
            set.add(new Quiz(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }


        m = Integer.parseInt(reader.readLine());
        for(int i = 0; i < m; i++) {
            req(reader.readLine());
        }

        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }

    static void req(String str){
//        pq.forEach((k, v) -> System.out.print(k + " " + v + " "));
        String[] strs = str.split(" ");
        if(strs[0].equals("recommend")){
            sb.append(recommend(Integer.parseInt(strs[1]))+ "\n");
        }else if(strs[0].equals("add")){
            add(Integer.parseInt(strs[1]) , Integer.parseInt(strs[2]));
        }else if(strs[0].equals("solved")){
            solved(Integer.parseInt(strs[1]));
        }
    }

    static int recommend(int i){
        if(i == 1){
            return set.pollLast().num;
        }else if(i == -1){
            return set.pollFirst().num;
        }
        return 0;
    }

    static void add(int num, int diff){
        set.add(new Quiz(num, diff));
    }

    static void solved(int num){
        set.removeIf(i -> i.num ==  num);
    }



}
