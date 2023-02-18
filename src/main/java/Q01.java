import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q01 {

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        String s = sc.next();
//        char[] arr = s.toCharArray();
//
//        int sum = 0;
//
//        for(int i = 0; i < arr.length; i++) {
//            sum = sum + arr[i] - '0';
//
//        }
//        System.out.println(sum);


//    Scanner sc = new Scanner(System.in);
//
//    int num =  sc.nextInt();
//    int t =  sc.nextInt();
//
//    int[] arr = new int[num];
//    int[] sum = new int[num];
//
//    for (int i = 0; i < num; i++) {
//        arr[i] = sc.nextInt();
//    }
//
//    sum[0] = arr[0];
//    for (int i = 1; i < num; i++) {
//        sum[i] = sum[i-1] + arr[i];
//    }
//
//    for (int i = 0; i < num; i++) {
//        System.out.println(sum[i]);
//    }
//
//    int start = 0;
//    int end = 0;
//    int answer = 0;
//
//    for (int i = 0; i < t; i++) {
//        start = sc.nextInt()-1;
//        end = sc.nextInt()-1;
//
//        try{
//            answer = sum[end] - sum[start-1];
//        }catch (Exception e){
//            answer = sum[end];
//        }
//
//        System.out.println(answer);

//        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stringTokenizer =  new StringTokenizer(bufferedReader.readLine());
//        int size = Integer.parseInt(stringTokenizer.nextToken());
//        int t =  Integer.parseInt(stringTokenizer.nextToken());
//
//
//        int[][] a = new int[size][size];
//        int[][] s = new int[size+1][size+1];
//
//        for (int i = 0; i <size; i++) {
//            stringTokenizer =  new StringTokenizer(bufferedReader.readLine());
//
//            for (int j = 0; j <size; j++) {
//                a[i][j] = Integer.parseInt((stringTokenizer.nextToken()));
//            }
//        }
//
//
//        for (int i = 1; i <size+1; i++) {
//            for (int j = 1; j < size+1; j++) {
//                s[i][j] = s[i-1][j] + s[i][j-1] -s[i-1][j-1] + a[i][j];
//            }
//        }
//
//
//
//        for (int i= 0; i < t ; i++){
//            stringTokenizer =  new StringTokenizer(bufferedReader.readLine());
//
//            int x1 =  Integer.parseInt(stringTokenizer.nextToken());
//            int y1 =  Integer.parseInt(stringTokenizer.nextToken());
//            int x2 =  Integer.parseInt(stringTokenizer.nextToken());
//            int y2 =  Integer.parseInt(stringTokenizer.nextToken());
//
//            int answer = s[x2][y2] - s[x2][y1-1] -s[x1-1][y2] + s[x1-1][y1-1];
//        }

//
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int lengthA = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] s1 = new int[lengthA];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < lengthA; i++) {
            s1[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] s2 = new int[lengthA+1];
        int[] s3 = new int[lengthA+1];
        int[] s4 = new int[m];


        for (int i = 1; i < lengthA+1; i++) {
            s2[i] = s2[i-1] + s1[i-1];
        }

        List<int[]> total = new ArrayList<int[]>();

//        for (int i = 1; i < lengthA+1; i++) {
//            s3[i] = s2[i] % m ;
//        }
//
//        for (int i = 1 ; i < lengthA+1; i++) {
//            s4[s3[i]]++;
//        }
//
//        int answer = s4[0];
//
//        for (int i = 0 ; i < m; i++) {
//            answer += (s4[i]*(s4[i]-1))/2;
//        }
//
//
//
//
//
//        for (int i = 0; i < s1.length; i++){
//            System.out.print(s1[i]);
//        }
//        System.out.println();
//        for (int i = 0; i < s2.length; i++){
//            System.out.print(s2[i]);
//        }
//        System.out.println();
//
//        for (int i = 0; i < s3.length; i++){
//            System.out.print(s3[i]);
//        }
//        System.out.println();
//
//        for (int i = 0; i < s4.length; i++){
//            System.out.print(s4[i]);
//        }
//        System.out.println();
//
//
//        System.out.println("answer: "  + answer);
//
//    }
//
//
//
        int[] arr =  new int[]{1,2,3,1,2};
        boolean[] visited =  new boolean[5];

        comb(arr,visited, 0, 2);

    }



    static void comb(int[] arr, boolean[] visited, int depth, int r) {

        if (r == 0) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(visited[i]);
            }
            return;
        }
        if(depth != arr.length) {
            visited[depth] = true;
            comb(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb(arr, visited, depth + 1, r);
        }

    }

}

