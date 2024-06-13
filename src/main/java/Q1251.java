import java.io.*;
import java.util.PriorityQueue;

public class Q1251 {
    /*
    *	15172	156
    *
    * */

    static class Alpha{
        char str;
        int idx;

        public Alpha(char str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }

    static PriorityQueue<Alpha> list = new PriorityQueue<Alpha>((o1, o2) -> o1.str - o2.str);
    static int first, second, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = reader.readLine();
        for(int i = 0; i< origin.length() -1 ; i++){
            list.add(new Alpha(origin.charAt(i), i));
        }

        int a = list.poll().idx;
        int b = list.poll().idx;

        first = Math.min(a,b);
        second = Math.max(a,b);

        StringBuilder answer = new StringBuilder();
        StringBuilder part = new StringBuilder();
        for(int i = 0; i < origin.length(); i++){
            part.append(origin.charAt(i));
            if(i == first || i == second){
                answer.append(part.reverse());
                part = new StringBuilder();
            }
        }
        answer.append(part.reverse());


        writer.write(answer.toString() + " ");
        writer.flush();
        writer.close();
    }

}
