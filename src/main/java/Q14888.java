import java.util.*;

public class Q14888{
    static boolean[] v;
    static int num;
    static List<Integer> result;
    static List<String> sign;
    static List<Integer> list;


    public static void main(String[] args){

        Scanner sc =  new Scanner(System.in);
        num = sc.nextInt();
        String[] str = {"+", "-", "*", "%"};

        list =  new ArrayList<>();
        sign =  new ArrayList<>();
        result =  new ArrayList<>();

        v = new boolean[num-1];


        for(int i =0; i< num; i++){
            list.add(sc.nextInt());
        }

        for(int i =0; i< 4; i++){
            int a = sc.nextInt();
            for(int j = 0; j< a; j++){
                sign.add(str[i]);
            }
        }




        dfs(0, list.get(0));

        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));



    }

    static void dfs(int depth, int total) {
//        if (depth == sign.size()) {
//            for(int i = 0; i< num-1; i++){
//                if (re.get(i).equals("+")) {
//                    total += list.get(i+1);
//                } else if (re.get(i).equals("-")) {
//                    total -= list.get(i+1);
//                } else if (re.get(i).equals("*")) {
//                    total *= list.get(i+1);
//                } else if (re.get(i).equals("%")) {
//                    if(total<0) {
//                        total = Math.abs(total);
//                        total /= list.get(i+1);
//                        total = total*(-1);
//                    }else{
//                        total/= list.get(i+1);
//                    }
//                }
//            }
//            re =  new ArrayList<>();
//            result.add(total);
//            return;
//        }
//
//        for(int i =0; i< sign.size(); i++) {
//            if (!v[i]) {
//                v[i] = true;
//                if (sign.get(i).equals("+")) {
//                    re.add("+");
//                } else if (sign.get(i).equals("-")) {
//                    re.add("-");
//                } else if (sign.get(i).equals("*")) {
//                    re.add("*");
//                } else if (sign.get(i).equals("%")) {
//                    re.add("%");
//                }
//                System.out.println(re);
//                dfs(depth + 1, total);
//                v[i] = false;
//            }
//        }

        if(depth == sign.size()){
            result.add(total);
        }
        for(int i =0; i< sign.size(); i++){
            if(!v[i]){
                v[i] = true;

                if (sign.get(i).equals("+")) {
                    dfs(depth+1, total + list.get(depth+1));
                } else if (sign.get(i).equals("-")) {
                    dfs(depth+1, total - list.get(depth+1));
                } else if (sign.get(i).equals("*")) {
                    dfs(depth+1, total * list.get(depth+1));
                } else if (sign.get(i).equals("%")) {
                    dfs(depth+1, total / list.get(depth+1));
                }

                v[i] = false;


            }
        }
    }




}

