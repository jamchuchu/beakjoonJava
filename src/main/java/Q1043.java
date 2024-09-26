import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q1043 {


    /*
    * 진실을 아는 사람이 파티에 왔는가?
    * 왔다 -> 진실만을 말하기
    *
    * 진신을 아는 사람이 온 파티에서는 무조건 진실 == 해당 파티에 온 사람들을 앞으로 만나면 무조건 진실말하기
    *
    * 전체 탐색해서 파티마다 진실 아는 사람이 잇느지 판별
    * 있으면 해당 파티는 진실 아는 파티로 추가
    *
    * 순서대로 가면 안되는데?
    *
    * 모든 순서 다돌려고 하면 안됨 그냥 그래프 그려야 할듯?
    *
    *
    * */

    static int answer, n, m, knowPersonNum;
    static boolean[] knowPerson;
    static List<List<Integer>> g = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        knowPerson = new boolean[n+1];

        str = reader.readLine().split(" ");
        knowPersonNum = Integer.parseInt(str[0]);
        for(int i = 0 ; i< knowPersonNum ; i++){
            knowPerson[Integer.parseInt(str[i+1])] = true;
        }

        for(int i = 0 ; i < m ; i++){
            g.add(new ArrayList<>());

            boolean flag = false;

            str = reader.readLine().split(" ");
            int partyNum = Integer.parseInt(str[0]);
            for(int j = 0 ; j < partyNum ; j++){
                int personNum = Integer.parseInt(str[j+1]);
                g.get(i).add(personNum);
                if(knowPerson[personNum]){
                    flag = true;
                }
            }

//            System.out.println(g);

            if(flag){
//                System.out.println(i);
                for(int num : g.get(i)){
//                    System.out.println(num);
                    knowPerson[num] = true;
                }
            }
        }

//        for(int i = 0 ; i <= n; i++){
//            System.out.print(knowPerson[i] + " ");
//        }
//        System.out.println();

        for(int i = 0 ; i <m ; i++){
            boolean flag = false;

            for(int num : g.get(i)){
                if(knowPerson[num]){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                answer++;
            }
        }



        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }
}
