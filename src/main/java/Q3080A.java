import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3080A {
    static BigInteger big = new BigInteger(String.valueOf(1000000007));
    static BigInteger[] fac = new BigInteger[27];


    static int n;
    static List<List<String>> strss = new ArrayList<>();
    static List<String> strs = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();
        factorial();

        System.out.println(strss);
        while(true){
            //자리수
            int j = 0;
            List<Map<String, List<String>>> maps = new ArrayList<>();

            //strss 안에서 한그룹 들고옴
            for(List<String> strs : strss){
                Map<String, List<String>> map = new HashMap<>();
                for (int i = 0; i < strs.size(); i++) {
                    String s = strs.get(i);
                    //str한개씩 빼와서 자리수 별로 저장
                    //strs 의 i 의 j 번재 글자를 들고와서 새 map에 넣은 다음 (j, json)
                    try {
                        String str = s.substring(j, j + 1);
                        List<String> list = map.getOrDefault(str, new ArrayList<>());
                        list.add(s);
                        map.put(str, list);
                    } catch (Exception e) {
                        List<String> list = map.getOrDefault("", new ArrayList<>());
                        list.add(s);
                        map.put("", list);
                    }
                }
                maps.add(map);
                //현재 가지수 저장
                int count = map.size();

                /*
                 * 1개일때는 현재가 마지막 노드
                 * size가 2 이상
                 * j가 마지막 글자인 것 여기서 끝 --현재 단계에서 가지 분리
                 * j가 마지막 아닌것 -- 다음 단계로
                 * */
                for (Map.Entry<String, List<String>> e : map.entrySet()) {
                    if (e.getValue().size() == 1) {
                        continue;
                    }
                    if (e.getKey() == "") {
                        count += e.getValue().size();
                        continue;
                    }
                    strs = new ArrayList<>(e.getValue());
                }


                j++;
            }
            strss.clear();
            strss.add(strs);
            System.out.println(maps);

        }
    }


    //입력
    static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        strs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String s = reader.readLine();
            strs.add(s);
        }
        strss.add(strs);
    }

    //팩토리얼 생성
    static void factorial(){
        fac[1] = new BigInteger(String.valueOf(1));
        for(int i = 2 ; i< 26; i++){
            BigInteger a = new BigInteger(String.valueOf(fac[i-1]));
            BigInteger b = new BigInteger(String.valueOf(i));
            fac[i]  = a.multiply(b);
        }
    }
}
