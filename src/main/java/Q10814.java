import java.util.*;

class Q10814 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        int num = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        List<String> nameList = new ArrayList<>();

        for(int i = 0 ; i< num; i++){
            st =  new StringTokenizer(sc.nextLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            map.put(name, age);
            nameList.add(name);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>();

        for(int i = 0 ; i< num; i++) {
            entryList.add(Map.entry(nameList.get(i), map.get(nameList.get(i))));
        }

        entryList.sort(Map.Entry.comparingByValue());

        entryList.forEach(entry -> {
            System.out.println(entry.getValue() + " " + entry.getKey());
        });
    }
}