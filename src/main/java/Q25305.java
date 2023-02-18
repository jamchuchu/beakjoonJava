import java.util.*;

class Q25305{
    public static void main(String[] args){

        Scanner sc =new Scanner(System.in);
        int num = sc.nextInt();
        int price = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i= 0; i < num; i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        System.out.print(list.get(list.size()-price));
    }
}