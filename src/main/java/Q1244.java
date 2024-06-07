import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1244 {
    static int n , m;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        list = new int[n];
        list = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(reader.readLine());
        for(int k = 0; k < m; k++) {
            String[] str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if(a == 1){//남
                int e = b;
                while(b <= n){
                    list[b-1] = function((list[b-1]));
                    b += e;
                }
            }else{//여
                int i = 0;
                while(true){
                    i++;
                    try{
                        int c = b - i;
                        int d = b + i;
                        if (list[c - 1] == list[d - 1]) {
                            continue;
                        } else {
                            break;
                        }
                    }catch(Exception e){
                        break;
                    }
                }
                i--;

                for(int j = b - i -1 ; j < b + i ; j++){
                    list[j] = function(list[j]);
                }
            }

        }
        for(int i = 0 ; i< n; i++){
            if(i % 20 == 0 && i > 0){
                System.out.println();
            }
            System.out.print(list[i] + " ");
        }
    }

    static int function(int num){
        if( num == 1){
            return 0;
        }else{
            return 1;
        }
    }
}
