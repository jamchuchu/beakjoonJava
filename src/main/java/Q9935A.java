import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q9935A {
    static ArrayDeque<String> str = new ArrayDeque<>();
    static ArrayDeque<String> candi = new ArrayDeque<>();
    static ArrayDeque<String> answer = new ArrayDeque<>();
    static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        str.addAll(Arrays.stream(reader.readLine().split(""))
                .collect(Collectors.toList()));
        target = reader.readLine();
        int length = target.length();

        while(!str.isEmpty()){

            if(candi.size() == length){
                if(candi.stream().collect(Collectors.joining()).equals(target)){
                    candi.clear();
                }else{
                    answer.addLast(candi.pollFirst());
                }
                continue;
            }
            if(candi.size() == length - 1) {
                candi.add(str.pollFirst());
            }
            if(candi.size() != length){
                if(!answer.isEmpty()){
                    candi.add(answer.pollLast());
                    continue;
                }
                if(!str.isEmpty()){
                    candi.add(str.pollFirst());
                }
            }
        }

        writer.write(answer.size() == 0 ? "FRULA": answer.stream().collect(Collectors.joining()));
        writer.flush();
        writer.close();
    }
}
