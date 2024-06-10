import java.io.*;
import java.util.Arrays;

public class Q18870B {
    /*
    * 정렬, 필터 후 이진탐색 해서 idx 찾기
    * */

    static int n;
    static int[] sortedMap, map, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        map = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sortedMap = Arrays.stream(map).distinct().toArray();
        Arrays.sort(sortedMap);

        answer = new int[n];
        for(int i = 0; i< n; i++) {
            answer[i] = binarySort(map[i]);
            writer.write(answer[i] + " ");
        }

        writer.flush();
        writer.close();
    }

    static int binarySort(int target){
        int start = 0;
        int end = sortedMap.length;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) /2;

            if(sortedMap[mid] == target){
                return mid;
            }

            if (sortedMap[mid] < target) {
                start = mid + 1;
            }else if(sortedMap[mid] > target) {
                end = mid;
            }
        }
        return mid;
    }



}
