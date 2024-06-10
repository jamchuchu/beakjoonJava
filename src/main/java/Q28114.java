import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q28114 {

    /*
    * 시키는 대로 정렬후 이름 탈색
    *
    * 	14524	140
    *
    * */

    static class Parti{
        int problem;
        int year;
        String name;

        public Parti(String problem, String year, String name) {
            this.problem = Integer.parseInt(problem);
            this.year = Integer.parseInt(year);
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Parti> partis = new ArrayList<>();
        String teamName = "";
        for(int i = 0 ;  i< 3; i++){
            String[] str = reader.readLine().split(" ");
            partis.add(new Parti(str[0], str[1], str[2]));
        }
        Collections.sort(partis, (o1, o2) -> o1.year - o2.year);
        teamName = partis.stream().map(j-> String.valueOf(j.year).substring(2,4))
                .collect(Collectors.joining(""));
        writer.write(teamName + "\n");
        Collections.sort(partis, (o1, o2) -> o2.problem - o1.problem);
        teamName = partis.stream().map(j-> j.name.substring(0,1)).collect(Collectors.joining(""));
        writer.write(teamName + "\n");


        writer.flush();
        writer.close();
    }


}
