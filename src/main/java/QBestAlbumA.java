import java.util.ArrayList;
import java.util.List;

public class QBestAlbumA {
    class Total{
        String g;
        int plays;
    }

    static List<Total> list = new ArrayList<>();

    static Total findGenes(String genres){
        for(Total t : list){
            if(t.g.equals(genres)){
                return t;
            }
        }
        return null;
    }

    class Music{
        int play;
        int num;
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer= new int[4];
        for(int i = 0; i < genres.length; i++) {
            Total total = findGenes(genres[i]);
            if(total== null){
                Total t = new Total();
                t.g = genres[i];
                t.plays = plays[i];
                list.add(t);
            }else{
                total.g = genres[i];
                total.plays += plays[i];
            }
        }
        list.sort((o1, o2)->
                o2.plays - o1.plays);
        String fir = list.get(0).g;
        String sec = list.get(1).g;
        List<Music> firList = new ArrayList<Music>();
        List<Music> secList = new ArrayList<Music>();

        for(int i = 0; i< genres.length; i++){
            if(fir.equals(genres[i])){
                Music m=  new Music();
                m.play = plays[i];
                m.num = i;
                firList.add(m)
;           }else if(sec.equals(genres[i])){
                Music m=  new Music();
                m.play = plays[i];
                m.num = i;
                secList.add(m);
            }
        }

        firList.sort((o1, o2) ->
                o2.num - o1.num);
        secList.sort((o1, o2) ->
                o2.num - o1.num);

        answer[0] = firList.get(0).num;
        answer[1] = firList.get(1).num;
        answer[2] = secList.get(0).num;
        answer[3] = secList.get(1).num;

        return answer;
    }
}
