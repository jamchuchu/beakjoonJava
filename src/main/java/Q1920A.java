import java.io.*;
import java.util.*;

public class Q1920A {
    /*
    *
    * 이진탐색 문제
    * 개수는 많지 않은데 그냥은 시간 초과 임
    * 숫자 자체가 크니 long 으로 하기
    * 	49308	828
    *
    * */
    static int n,m;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        while(st.hasMoreTokens()) {
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);

        m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        while(st.hasMoreTokens()) {
            int start = 0;
            int end = n;
            Long target = Long.parseLong(st.nextToken());
            boolean flag = false;

            while(start < end){
                int mid = (start + end)/ 2;
                if(Objects.equals(list.get(mid), target)){
                    flag = true;
                    break;
                }
                if( target < list.get(mid)){
                    end = mid ;
                }else{
                    start = mid + 1;
                }
            }
            writer.write(flag ? "1\n" : "0\n" );


        }

        writer.flush();
        writer.close();
    }
}
