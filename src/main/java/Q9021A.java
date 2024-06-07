import java.io.*;

public class Q9021A {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            boolean answer = true;
            int count = 0;
            String[] str = reader.readLine().split("");

            for(int j = 0; j < str.length; j++) {

                if(str[j].equals("(")){
                    count++;
                }else{
                    count--;
                    if(count < 0){
                        answer = false;
                    }
                }
            }
            if(count != 0){
                answer = false;
            }
            writer.write(answer? "YES\n" : "NO\n");
        }

        writer.flush();
        writer.close();
    }

}
