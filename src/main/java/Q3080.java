public class Q3080 {
//    /*
//    * 첫 예시 분석 큰 덩어리로 나눔 괄호 문제 같은?
//    * 트리 같은데?
//    * 항상 정렬 하면 가능이긴한데
//    * 각각의 역방향이 가능 ..?
//    *
//    * 각 레벨의 node의 팩토리얼의 곱
//    * 자리수 마다 리스트만들어서 넣기 // 처음부터 3000개 하든, max 구해서 하든
//    * distint와 개수 구하기
//    * 팩토리얼의 곱
//
//    * */
//    static BigInteger big = new BigInteger(String.valueOf(1000000007));
//    static BigInteger[] fac = new BigInteger[27];
//
//
//    static int n;
//    static List<List<String>> strss = new ArrayList<>();
//    static List<String> strs = new ArrayList<>();
//
//    static List<Integer> counts = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//        while (true){
//            input();
//            factorial();
//
//            //자리수
//            int j = 0;
//            List<Map<String, List<String>>> maps = new ArrayList<>();
//
//            while (true) {
//                Map<String, List<String>> map = new HashMap<>();
//
//                for(List<String> strs : strss){
//                    for (int i = 0; i < strs.size(); i++) {
//                        String s = strs.get(i);
//
//                        //strs 의 i 의 j 번재 글자를 들고와서 새 map에 넣은 다음 (j, json)
//                        try {
//                            String str = s.substring(j, j + 1);
//                            List<String> list = map.getOrDefault(str, new ArrayList<>());
//                            list.add(s);
//                            map.put(str, list);
//                        } catch (Exception e) {
//                            List<String> list = map.getOrDefault("", new ArrayList<>());
//                            list.add(s);
//                            map.put("", list);
//                        }
//                    }
//                    maps.add(map);
//                    System.out.println(maps);
//
//                    //현재 가지수 저장
//                    int count = map.size();
//
//                /*
//                 * 1개일때는 현재가 마지막 노드
//                 * size가 2 이상
//                 * j가 마지막 글자인 것 여기서 끝 --현재 단계에서 가지 분리
//                 * j가 마지막 아닌것 -- 다음 단계로
//                 * */
//                List<List<String>> temps = new ArrayList<>();
//                for (Map.Entry<String, List<String>> e : map.entrySet()) {
//                    List<String> temp = new ArrayList<>();
//                    if (e.getValue().size() == 1) {
//                        continue;
//                    }
//                    if (e.getKey() == "") {
//                        count += e.getValue().size() ;
//                        continue;
//                    }
//                    temp.addAll(e.getValue());
//                }
//                counts.add(count);
//
//                //다음 strs 목록이 없으면 stop
//                    if (temp.isEmpty()) {
//                        break;
//                    }
//                // 있으면 strs 리셋
//                    strss.clear();
//                    strss.addAll(temps);
//                    j++;
//                }
//            }
//
//        System.out.println(counts);
//            BigInteger answer = new BigInteger(String.valueOf(1));
//
//            for (int i = 0; i < counts.size(); i++) {
//                int size = counts.get(i);
//                BigInteger a = new BigInteger(String.valueOf(fac[size]));
//                BigInteger b = new BigInteger(String.valueOf(answer));
//
//                answer = a.multiply(b).remainder(big);
//            }
//            System.out.println(answer);
//        }
//    }
//
//
//    //입력
//    static void input() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(reader.readLine());
//        strs = new ArrayList<>();
//        for(int i = 0; i < n; i++) {
//            String s = reader.readLine();
//            strs.add(s);
//        }
//        strss.add(strs);
//    }
//
//    //팩토리얼 생성
//    static void factorial(){
//        fac[1] = new BigInteger(String.valueOf(1));
//        for(int i = 2 ; i< 26; i++){
//            BigInteger a = new BigInteger(String.valueOf(fac[i-1]));
//            BigInteger b = new BigInteger(String.valueOf(i));
//            fac[i]  = a.multiply(b);
//        }
//    }



}
