import java.util.Scanner;

public class Q06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        int score = 1;
        int totalScore = 0;

        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            String[] ox = line.split("");
            int[] oxNum = new int[ox.length];
            int[] oxScore = new int[ox.length];
            for (int j = 0; j < ox.length; j++) {
                if (ox[j].equals("O")) {
                    oxNum[j] = 1;
                }
            } // ox Num

            oxScore[0] = oxNum[0];


            for (int j = 1; j < ox.length; j++) {
                if(oxNum[j] == 0){
                    oxScore[j] = 0;
                }else{
                    oxScore[j] =  oxScore[j-1]+1;
                }
            }




            for (int j = 0; j < ox.length; j++) {
                totalScore += oxScore[j];
            }
            System.out.println(totalScore);
            totalScore = 0;
        }

    }
}
