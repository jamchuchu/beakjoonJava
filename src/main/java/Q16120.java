import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q16120 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<String> deq = new ArrayDeque<>(Arrays.stream(reader.readLine().split("")).collect(Collectors.toList()));
        List<String> answer = new ArrayList<>();

        while(true) {
            if(answer.size() < 4){
                answer.add(deq.pollFirst());
            }else{
                StringBuilder sb = new StringBuilder();
                for(int i = answer.size() - 4 ; i < answer.size(); i++){
                    sb.append(answer.get(i));
                }
                if(sb.toString().equals("PPAP")){
                    for(int i =  0 ; i < 3 ; i++){
                        answer.remove(answer.size() -1);
                    }
                }else{
                    answer.add(deq.pollFirst());
                }
                if (deq.isEmpty()){
                    break;
                }
            }
        }

        writer.write(answer.stream().filter(Objects::nonNull).collect(Collectors.joining()).equals("P") ? "PPAP" : "NP");
        writer.flush();
        writer.close();
    }


}
