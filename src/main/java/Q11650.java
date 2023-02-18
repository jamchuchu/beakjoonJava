import java.util.*;
import java.io.*;


class Q11650{
    public static void main(String[] args) throws IOException {

        BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(sc.readLine());
        List<int[]> list = new ArrayList<int[]>();

        for(int i =0; i < num; i++){
            int[] arr = new int[2];
            String temp =  sc.readLine();
            st = new StringTokenizer(temp);
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());

            list.add(arr);
        }
        List<Integer> list2 = new ArrayList<Integer>();
        Set<Integer> set =  new HashSet<Integer>();

        for(int i = 0; i< num; i++){
            int[] temp = list.get(i);
            set.add(temp[0]);
        }

        List<Integer> list1 = new ArrayList<Integer>(set);
        Collections.sort(list1);


        for(int i = 0; i< list1.size(); i++){
            int a = list1.get(i);

            for(int j = 0; j< num; j++) {
                int[] temp = list.get(j);
                if (temp[0] == a) {
                    list2.add(temp[1]);
                }
            }
            Collections.sort(list2);
            for(int j = 0; j< list2.size(); j++){
                String line = a + " " + list2.get(j);
                bw.write( line);
                bw.write("\n");

            }

            list2.clear();

        }
        bw.flush();






    }


}