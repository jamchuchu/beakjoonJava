import java.util.*;
import java.io.*;


class Q2751{
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int num = Integer.parseInt(bf.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i =0; i< num; i++){
            list.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(list);

        for(int i =0; i< list.size(); i++){
            bw.write(list.get(i).toString());
        }

    }
}