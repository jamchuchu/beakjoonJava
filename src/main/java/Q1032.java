import java.util.Scanner;

public class Q1032 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] str = new String[n];
        for(int i = 0; i < n; i++) {
            str[i] = scanner.nextLine();
        }
        String[] answer = new String[str[0]. length()];
        for(int i = 0; i < str[0].length() ; i++){
            char s = str[0].charAt(i);
            for(int j = 0; j < str.length ; j++){
                if(str[j].charAt(i) != s){
                    answer[i] = "?";
                    break;
                }
                if(j == str.length-1){
                    answer[i] = str[0].split("")[i];
                }
            }
        }
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]);
        }
    }
}
