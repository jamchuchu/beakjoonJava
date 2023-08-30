import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Q11723 {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(sc.readLine());

        Set<String> set = new HashSet<>();
        Set<String> newSet = new HashSet<>();
        for(int i =0; i < 20; i++){
            newSet.add(String.valueOf(i+1));
        }


        for(int i =0 ; i < num; i++){
            String[] str = sc.readLine().split(" ");
            if(str[0].equals("add")){
                set.add(str[1]);
            }else if(str[0].equals("remove")){
                set.remove(str[1]);
            }else if(str[0].equals("check")){
                if(set.contains(str[1])){
                    bw.write("1"+ "\n");
                }else{
                    bw.write("0"+ "\n");
                }
            }else if(str[0].equals("toggle")){
                if(set.contains(str[1])){
                    set.remove(str[1]);
                }else{
                    set.add(str[1]);
                }
            }else if(str[0].equals("all")){
                set.clear();
                set.addAll(newSet);
            }else if(str[0].equals("empty")){
                set.clear();
            }
        }
        bw.flush();
    }
}
