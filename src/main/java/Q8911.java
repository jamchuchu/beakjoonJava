import java.io.*;
//	209600	1472
public class Q8911 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n, x, y, dir, xMax,xMin,yMax,yMin, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        for(int i =  0; i < n; i++) {
            String[] ques = reader.readLine().split("");
            dir = 0; x = 0; y = 0;
            xMax = 0;yMax = 0;xMin = 0;yMin = 0;
            for(String s : ques){
                move(s);
                saveLocation();
            }
            answer = (xMax - xMin) * (yMax - yMin);
            writer.write(answer + "\n");
        }
        writer.flush();
        writer.close();
    }

    static void go(){
        x += dx[dir];
        y += dy[dir];
    }
    static void back(){
        x -= dx[dir];
        y -= dy[dir];
    }
    static void right(){//U = 0, R = 1, D = 2, L = 3
         dir = (dir+1)%4;
    }
    static void left(){
         dir = (dir+3)%4;
    }
    static void move(String str){
        if(str.equals("F")){
            go();
        }else if(str.equals("B")){
            back();
        }else if(str.equals("L")){
            left();
        }else if(str.equals("R")){
            right();
        }
    }
    static void saveLocation(){
        xMax = Math.max(xMax,x);
        yMax = Math.max(yMax,y);
        xMin = Math.min(xMin,x);
        yMin = Math.min(yMin,y);
    }

}
