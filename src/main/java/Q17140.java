import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
* 행 >= 열
*
* 행에 대해서 정렬
*
* 기본 맵은 리스트로 구성
*
* 각 숫자, 갯수 한다음 카운트  -> 맵이 빠를것 같긴한데 .. stream 쓰고 싶기도 하고
*
* 정렬이 value 에 대해서 정렬 후 key 에 대해서 정렬이니깐
* key ,value로 받은 다음 pq로 옮겨서 바로 정리가 깔끔할지도
*
* 최대 개수 카운트 후 나머지는 0으로 채움
* 카운트 시에는 0은 무시 0으로 채우는 거의 의미가 있나?
* 길이 짧은거의 예외 처리 정도인것 같은데..
*
*
* 아마 시간초과의 문제인듯 시키는 대로 하면 시간초과 가능성 높아보임
*
* */

class Number{
    int num, count;

    public Number(int num, int count) {
        this.num = num;
        this.count = count;
    }
}


public class Q17140 {
    static int answer, r,c,k, maxC;
    static List<List<Integer>> list = new ArrayList<>();
    static Map<Integer, Integer> countMap = new HashMap<>();
    static PriorityQueue<Number> pq = new PriorityQueue<>((o1, o2) -> {
        if(o1.count == o2.count)return o1.num - o2.num;
        return o1.count - o2.count;
    });


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        r = Integer.parseInt(str[0])-1;
        c = Integer.parseInt(str[1])-1;
        k = Integer.parseInt(str[2]);

        for(int i = 0; i < 3; i++){
            list.add(Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList()));
        }
        maxC  = 3;


        while(answer < 10) {
            try {
                if (list.get(r).get(c) == k) {
                    break;
                }
            }catch (Exception e){

            }
            answer++;
            if (list.size() >= maxC) {
                int size = list.size();
                maxC = 0;

                for (int i = 0; i < size; i++) {
                    if(i == 100){
                        break;
                    }
                    List<Integer> temp = sort(list.remove(0), true);
                    list.add(temp);
                }

            }else{
                List<List<Integer>> reverseList = reverseList(list);

                int size = reverseList.size();
                for (int i = 0; i < size; i++) {
                    if(i == 100){
                        break;
                    }
                    List<Integer> temp = sort(reverseList.remove(0), false);
                    reverseList.add(temp);
                }
                maxC = reverseList.size();
                list = reverseList(reverseList);
            }

            System.out.println(list);



        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static List<List<Integer>> reverseList(List<List<Integer>> target){
        List<List<Integer>> reverseList = new ArrayList<>();
        for(int i = 0; i < maxC; i++){
            reverseList.add(new ArrayList<>());
        }
        for(int i = 0 ; i <  target.size() ; i++){
            for(int j = 0 ; j <  target.get(i).size() ; j++){
                reverseList.get(j).add(target.get(i).get(j));
            }
        }
        return reverseList;
    }

    static List<Integer> sort(List<Integer> line, boolean doCount){
        countMap = new HashMap<>();
        for(Integer i : line){
            int count = countMap.getOrDefault(i , 0);
            countMap.put(i, count+1);
        }
        countMap.remove(0);
        if(doCount) {
            maxC = Math.max(maxC, countMap.size()*2); // 최대 C count
        }
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            pq.add(new Number(entry.getKey(), entry.getValue()));
        }
        List<Integer> temp = new ArrayList<>();
        while(!pq.isEmpty()){
            temp.add(pq.peek().num);
            temp.add(pq.poll().count);
        }
        return temp;
    }


}
