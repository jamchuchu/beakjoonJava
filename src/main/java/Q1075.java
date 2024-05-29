import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1075 {
    static int n;
    static Deque<Integer> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String str = st.nextToken();
            int a = 0;
            if(st.hasMoreTokens()){
                a = Integer.parseInt(st.nextToken());
            }
            mission(str, a);
        }
    }

    static void mission(String str, int a){
        if(str.equals("push")){
            que.add(a);
        }else if(str.equals("pop")){
            if(que.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(que.pollFirst());
            }
        }else if(str.equals("size")){
            System.out.println(que.size());
        }else if(str.equals("empty")){
            if(que.isEmpty()){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }else if(str.equals("front")){
            if(que.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(que.peekFirst());
            }
        }else if(str.equals("back")){
            if(que.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(que.peekLast());
            }
        }

    }
}
