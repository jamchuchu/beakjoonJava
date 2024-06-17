import java.io.*;

public class Q13305 {

    //그리디인듯?
    /*

    	39164	2048
    * 제일 싼 주유소에서 제일 뒤 까지 사는게 제일 이득
    * 10만 넣고 8추가 넣고 끝까지 가는게 제일 이득임
    * 뒤에서 오는건?
    * 앞에서 싼게 잇는가? o, x
    * o -> 안넣고 그냥 간다
    * x -> 이제까지 온 거리 합산 해서 다 넣는다 ㄱ, 거리 새로 갱신
    *
    *
    * */
    static int n;
    static long answer;
    static int[] values, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine())-1;
        dist = new int[n];
        values = new int[n];
        String[] str = reader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            dist[i] = Integer.parseInt(str[i]);
        }
        str = reader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            values[i] = Integer.parseInt(str[i]);
        }

        long distNum = 0; // 제일 뒤

        for(int i = n-1 ;i >= 0; i--){
            int now = values[i];
            distNum += dist[i];
            if(isContainCheaper(now, i)){// 나중에 이진으로 바꿔야 될지도
                continue;
            }else{// 현재까지 온 거리
                answer +=  distNum * values[i];
                distNum = 0;
            }
        }


        writer.write(answer+" ");
        writer.flush();
        writer.close();
    }

    static boolean isContainCheaper(int now, int idx){// 비싼게 있니?
        for(int j = idx-1; j >= 0 ; j--){
            int pre = values[j];
            if(pre < now){
                return true;
            }
        }
        return false;
    }

}
