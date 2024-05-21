import java.util.ArrayList;
import java.util.List;

public class QBestAlbum {
    class Genres{
        String genreName;
        int totalNum;
        List<Music> musics = new ArrayList<>();

        Genres(String genreName, int plays, int num){
            this.genreName = genreName;
            this.totalNum = num;
            musics.add(new Music(genreName, plays, num));
        }

        void addGenres(String genreName, int plays, int num){
            this.totalNum += totalNum;
            musics.add(new Music(genreName, plays, num));
        }
    }

    class Music{
        String genres;
        int plays;
        int num;

        public Music(String genres, int plays, int num) {
            this.genres = genres;
            this.plays = plays;
            this.num = num;
        }
    }

    static List<Genres> genresList = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[4];
        for(int i = 0; i < genres.length; i++) {
            findGenres(genres[i], plays[i], i);
        }
        genresList.sort((o1, o2) ->
            o2.totalNum - o1.totalNum
        );



        answer[0] = genresList.get(0).musics.get(0).num;
        answer[1] = genresList.get(0).musics.get(1).num;
        answer[2] = genresList.get(1).musics.get(0).num;
        answer[3] = genresList.get(1).musics.get(1).num;

        return answer;
    }

    void findGenres(String genre, int plays, int num){
        for(Genres g: genresList){
            if(g.genreName.equals(genre)){
                g.addGenres(genre, plays, num);
                return;
            }
        }
        genresList.add(new Genres(genre, plays, num));
    }
    public static void main(String[] args) {

    }
}
