import java.util.*;


/*
* 무조건 길이가 같아야 하나? 다르면 그냥 false 해도 될듯?
* a*/
public class Q1919 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        int[] strA = new int[26];
        int[] strB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            strA[(int) a.charAt(i) - 97]++;
            strB[(int) b.charAt(i) - 97]++;
        }


        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (strA[i] != strB[i]) {
//                    int max = Math.max(strA[i], strB[i]);
//                    int min = Math.min(strA[i], strB[i]);
                count += Math.abs(strA[i] - strB[i]);
            }
        }

        System.out.println(count);


    }
}
