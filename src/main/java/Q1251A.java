import java.io.*;
import java.util.PriorityQueue;

public class Q1251A {

    /*
    * 제일 빠른 알파벳 두개 뽑은다음에 뒤집으려고 했는데
    * 틀렸다고 떠서 일단 길이보고 전체탐색
    *	15172	156
    *
    * */

    static PriorityQueue<String> answers = new PriorityQueue<>();
    static String str;
    static int length;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        str = reader.readLine();
        length = str.length();
        dfs(length -1 , 2, 0, 0, new int[2]);


        writer.write(answers.poll() + " ");
        writer.flush();
        writer.close();
    }

    static void dfs(int n, int k, int depth, int num, int[] list){
        if(depth == k){
//            for(int i= 0 ; i < depth; i++){
//                System.out.print(list[i] + " ");
//            }
//            System.out.println();
            reverseWord(list);
            return;
        }
        for(int i = num ; i< n; i++){
            list[depth] = i;
            dfs(n, k, depth+1, i+1, list);
        }
    }

    static void reverseWord(int[] list){
        StringBuilder word = new StringBuilder();
        StringBuilder part = new StringBuilder();
        for(int i = 0; i < length; i++){
            part.append(str.charAt(i));
            if(i == list[0] || i == list[1]){
                word.append(part.reverse());
                part = new StringBuilder();
            }
        }
        word.append(part.reverse());
        answers.add(word.toString());
    }

}



