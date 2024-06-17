import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q1461 {
    static int answer, n,m, max;
    static List<Integer> plus = new ArrayList<>();
    static List<Integer> minus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        String[] books = reader.readLine().split(" ");
        for(int i = 0 ; i< n; i++){
            int book = Integer.parseInt(books[i]);
            max = Math.max(max, Math.abs(book));

            if(book > 0){
                plus.add(book);
            }else{
                minus.add(book * -1);
            }
        }

        Collections.sort(plus, Comparator.reverseOrder());
        Collections.sort(minus, Comparator.reverseOrder());

        if(max > 0){
            answer += plus.get(0);
            for(int i = 0 ; i< m ; i++){
                try {plus.remove(0);}catch (Exception e){}
            }
        }else{
            answer += minus.get(0);
            for(int i = 0 ; i< m ; i++){
                try {minus.remove(0);}catch (Exception e){}
            }
        }

        int i = 0;
        while(i * m < plus.size()){
            answer += plus.get(i * m) * 2;
            i++;
        }
        i = 0;
        while(i * m < minus.size()){
            answer += minus.get(i * m) * 2;
            i++;
        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
