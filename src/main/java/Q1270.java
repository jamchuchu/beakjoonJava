import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/* Map 의 총집합
* getOrDefault(armyNum, 0) + 1) default일때 바로 들고와서 더하기 !!
* sortedMap.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
* map sort 하는 방법
*
* 아주 큰수를 다루는 방법!
* BigInteger
*
* 입력 받아서 군대 이름 만큼 하나씩더하고 가장 큰 값을 들고 오면 되는 문제이다
* 간단하지만 구현상으로는 아주 복잡했는데
* value 값 기준으로 정렬하거나
* 군대명의 수가 아주 큰 수였기 때문에 다루기 어려운 부분이 잇엇다 -- long 범위임.

 * */
public class Q1270 {
    static int n, m;
    static Map<BigInteger, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        for( int i = 0; i < n; i++ ){
            StringTokenizer st = new StringTokenizer(reader.readLine());

            m = Integer.parseInt(st.nextToken());
            map = new TreeMap<>();

            for(int j = 0 ; j< m ; j++){

                BigInteger armyNum = new BigInteger(st.nextToken());
                map.put(armyNum, map.getOrDefault(armyNum, 0) + 1);
            }

            System.out.println(checkWinner());
        }
    }

    static String checkWinner(){
         List<Map.Entry<BigInteger, Integer>> sortedMap = new ArrayList<>(map.entrySet());
         sortedMap.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
         Map.Entry<BigInteger, Integer> first = sortedMap.get(0);


        if(first.getValue() > (long)m/2){
            return String.valueOf(first.getKey());
        }else{
            return "SYJKGW";
        }
    }
}
