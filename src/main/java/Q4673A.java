import java.io.*;

public class Q4673A {
    /*
    *14552	168
    * */


    static final int max = 10001;
    static int[] answer = new int[max];
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1 ; i< max; i++) {
            answer[i] = i;
        }

        for(int i = 1 ; i <  max; i++){
            if(answer[i] == 0){
                continue;
            }
            int num = i;
            while(true){
                num = calcNum(num);
                if(num >= max){
                    break;
                }
                answer[num] = 0;
            }
        }

        for(int i = 1 ; i< max; i++) {
            if(answer[i] != 0){
                writer.write(i+ "\n");
            }
        }

        writer.flush();
        writer.close();
    }

    static int calcNum(int num){

        int total = num;
        while(num >= 10) {
            total += num % 10;
            num /= 10;
        }
        return total + num;
    }
}
