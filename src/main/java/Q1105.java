import java.io.*;

public class Q1105 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split( " ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int answer = 0;


        String[] b = String.valueOf(m).split(""); // 큰것
        int size = b.length;
        String[] temp = String.valueOf(n).split("");
//        List<String> a = Arrays.stream(String.valueOf(n).split("")).collect(Collectors.toList()); // 큰것
//        while(a.size() < size){
//            a.add(0, "0");
//        }
        String[] a = new String[size];
        for(int i = 0 ; i< size; i++){
            if(temp.length - 1 -i >= 0) {
                a[size - 1 - i] = temp[temp.length - 1 - i];
            }else{
                a[size - 1 - i] = "0";
            }
        }

        for(int i = 0 ; i< size; i++){
            if(a[i].equals(b[i])){
                if(a[i].equals("8")){
                    answer++;
                }
            }else{
                break;
            }
        }


//        for(int i = n ; i<= m; i++){
//            int count = (int) Arrays.stream(String.valueOf(i).split("")).filter(x -> x.equals("8")).count();
//            answer = Math.min(count, answer);
//            if(answer == 0){
//                break;
//            }
//        }

        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

}
