
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q02 {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(bf.readLine());

        LinkedList deq = new LinkedList();
        int questionNum = Integer.parseInt(st.nextToken());


        for(int i = 0 ; i< questionNum ; i++) {

            st = new StringTokenizer(bf.readLine());
            String q = st.nextToken();

            switch (q){
                case "push_front":
                    deq.addFirst(Integer.parseInt(st.nextToken())); ;
                    break;
                case "push_back":
                    deq.addLast(Integer.parseInt(st.nextToken())); ;
                    break;
                case "pop_front":
                    try {
                        System.out.println(deq.removeFirst());
                    }catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    try {
                        System.out.println(deq.removeLast());
                    }catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(deq.size());
                    break;
                case "empty":
                    if(deq.size() == 0){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    try {
                        System.out.println(deq.getFirst());
                    }catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    try {
                        System.out.println(deq.getLast());
                    }catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
                case "print":
                    deq.forEach(value -> {
                        System.out.println(value);
                    });
                    break;
            }

        }

    }
}
