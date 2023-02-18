import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Q1316{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int num  = sc.nextInt();
        int answer = num;
        sc.nextLine();

        for(int i = 0; i < num; i++) {
            String[] line = sc.nextLine().split("");

            List<String> mem =  new ArrayList<String>();
            int a = 0;
            int b = 1;

            while(b < line.length){
                if(mem.contains(line[a])){
                    answer--;
                    break;
                }
                if(line[a].equals(line[b])){
                    b++;
                }else{
                    mem.add(line[a]);
                    a = b;
                    b++;
                }
            }
        }

        System.out.println(answer);
    }
}