import java.io.*;

public class Q1075A {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        int a  = (n/100) * 100;
        int b = ((n/100)+100) * 100;

        for(int i = a; i< b; i++){
            if(i % m == 0){
                answer = i % 100;
//                System.out.println(i + " " + answer);
                break;
            }
        }
        String str = String.valueOf(answer);
        if(answer < 10){
            str = "0" + str;
        }

        writer.write(str + " ");
        writer.flush();
        writer.close();
    }


}
