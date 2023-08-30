import java.util.Scanner;

public class Q1769 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        int sum = 0;
        int count = 0;
        if(str1.length() != 1) {
            for (int i = 0; i < str1.length(); i++) {
                sum += Character.getNumericValue(str1.charAt(i));
            }
            count = 1;
        }else{
            sum = Integer.parseInt(str1);
        }



////
//        while(sum > 9) {
//            count++;
//            String[] str = String.valueOf(sum).split("");
//            sum = 0;
//            int[] nums =  new int[str.length];
//
//            for (int i = 0; i < str.length; i++) {
//                nums[i] = Integer.parseInt(str[i]);
//                sum += nums[i];
//            }
//        }

        while (sum > 9) {
            count++;
            String str = Long.toString(sum);
            sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }
        }

        System.out.println(count);
        if(sum == 3 || sum == 6 || sum == 9){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
