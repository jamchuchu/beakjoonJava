import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Q04 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//
//        int num = sc.nextInt();
//        sc.nextLine();
//        List<Integer> list = new ArrayList<Integer>();
//
//        for (int i = 0; i < num; i++) {
//            String nums = sc.nextLine();
//            String[] numArr = nums.split(" ");
//            for (int j = 0; j < numArr.length; i++){
//                list.add(Integer.parseInt(numArr[i]));
//            }
//        }

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();


        for(int i = 0 ; i < num; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int a = 0;
        int b = 1;

        while(a < list.size()) {
            try {
                if (list.get(b) > list.get(a)) {
                    System.out.print(list.get(b) + " ");
                    a++;
                    b = a + 1;
                } else {
                    b++;
                }
            }catch (Exception e){
                a++;
                b = a + 1;
                System.out.print(-1 + " ");
            }
        }



    }
}
