import java.util.*;
import java.io.*;

class Q18870{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num =  sc.nextInt();
        sc.nextLine();

        int[] arr1 = new int[num];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        SortedSet<Integer> set =  new TreeSet<>() ;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i =0; i< num; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
            set.add(arr1[i]);
        }

        List<Integer> list =  new ArrayList<>(set);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< set.size(); i++){
            map.put(list.get(i), i);
        }



        int[] arr2 = new int[num];

        for(int i =0; i< num; i++) {
            arr2[i] = map.get(arr1[i]);
        }

        for(int i =0; i< num; i++){
            bw.write(arr2[i]+ " ");
        }
        bw.flush();

    }


}