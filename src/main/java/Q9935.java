import java.io.*;

public class Q9935 {
        static String a, b;
        static int bLeng;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        a = reader.readLine();
        b = reader.readLine();
        bLeng = b.length();

        while(true){
            if(!contains(a)){
                break;
            }
            a = a.replaceAll(b, "");
        }

        writer.write(a.isEmpty() ? "FRULA" : a);
        writer.flush();
        writer.close();
    }

    static boolean contains(String a){
        for(int i = 0; i + bLeng <= a.length() ; i++){
            if(a.substring(i , i + bLeng).equals(b)){
                return true;
            }
        }
        return false;
    }

}
