import java.io.*;
import java.util.ArrayList;

public class Q1713 {
    static int n, m;
    static ArrayList<int[]> deq = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");

        deq.add(new int[]{Integer.parseInt(str[0]),  1});

        for(int i = 1; i< m ;i++){
            // 순서대로 들고옴
            int now = Integer.parseInt(str[i]);
            // 안에 있으면
            boolean flag = false;
            for(int[] d : deq){
                if(d[0] == now){
                    flag = true;
                    d[1]++;
                }
            }
            if(!flag) {
                // 없으면
                if(deq.size() >= n){
                    deq.sort((o1, o2) -> o1[1] - o2[1]);
                    deq.remove(0);
                    deq.add(new int[]{now, 1});
                }else{
                    deq.add(new int[]{now, 1});
                }

            }
            for(int[] d : deq){
                System.out.print(d[0] + " " + d[1] + ", ");
            }
            System.out.println();
        }

        deq.sort((o1, o2) -> o1[0] - o2[0]);
        for(int[] d : deq){
            writer.write(d[0] + " ");
        }


        writer.flush();
        writer.close();
    }



}
