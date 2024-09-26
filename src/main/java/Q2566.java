import java.io.*;

public class Q2566 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = 0;
        int b = 0;
        for(int i = 0 ; i < 9 ; i++){
            String[] str = reader.readLine().split(" ");
            for(int j = 0 ; j < 9 ; j++){
                answer = Math.max(answer, Integer.parseInt(str[j]));
                if(answer == Integer.parseInt(str[j])){
                    a = i+1;
                    b = j+1;
                }
            }
        }

        writer.write(answer+"\n");
        writer.write(a + " "+ b);
        writer.flush();
        writer.close();
    }


}
