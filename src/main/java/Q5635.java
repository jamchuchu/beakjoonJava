import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Q5635 {

    static class Birth{
        private String name;
        private LocalDate birth;

        public Birth(String name, LocalDate birth){
            this.name =  name;
            this.birth =  birth;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(sc.readLine());
        Birth[] birth = new Birth[num];

        for (int i = 0; i < num; i++) {
            String[] str =  sc.readLine().split(" ");
            LocalDate date = LocalDate.of(Integer.parseInt(str[3]),Integer.parseInt(str[2]),Integer.parseInt(str[1]));
            birth[i] = new Birth(str[0],date);
        }

        Arrays.sort(birth, Comparator.comparing(b -> b.birth));

        System.out.println(birth[birth.length-1].name);
        System.out.println(birth[0].name);



    }
}
