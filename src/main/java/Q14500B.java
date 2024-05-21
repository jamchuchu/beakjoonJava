import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500B {
    static int n, m, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] block = new int[19][2][4];

        block[0][0] = new int[]{0,0,0,0};
        block[0][1] = new int[]{0,1,2,3};

        block[1][0] = new int[]{0,1,2,3};
        block[1][1] = new int[]{0,0,0,0};

        block[2][0] = new int[]{0,0,0,1};
        block[2][1] = new int[]{0,1,2,0};

        block[3][0] = new int[]{0,0,0,1};
        block[3][1] = new int[]{0,1,2,1};

        block[4][0] = new int[]{0,0,0,1};
        block[4][1] = new int[]{0,1,2,2};

        block[5][0] = new int[]{1,1,1,0};
        block[5][1] = new int[]{0,1,2,0};

        block[6][0] = new int[]{1,1,1,0};
        block[6][1] = new int[]{0,1,2,1};

        block[7][0] = new int[]{1,1,1,0};
        block[7][1] = new int[]{0,1,2,2};

        block[8][0] = new int[]{0,1,2,0};
        block[8][1] = new int[]{0,0,0,1};

        block[9][0] = new int[]{0,1,2,1};
        block[9][1] = new int[]{0,0,0,1};

        block[10][0] = new int[]{0,1,2,2};
        block[10][1] = new int[]{0,0,0,1};

        block[11][0] = new int[]{0,1,2,0};
        block[11][1] = new int[]{1,1,1,0};

        block[12][0] = new int[]{0,1,2,1};
        block[12][1] = new int[]{1,1,1,0};

        block[13][0] = new int[]{0,1,2,2};
        block[13][1] = new int[]{1,1,1,0};

        block[14][0] = new int[]{0,1,0,1};
        block[14][1] = new int[]{0,0,1,1};

        block[15][0] = new int[]{0,0,1,1};
        block[15][1] = new int[]{0,1,1,2};

        block[16][0] = new int[]{0,1,1,2};
        block[16][1] = new int[]{0,0,1,1};

        block[17][0] = new int[]{1,1,0,0};
        block[17][1] = new int[]{0,1,1,2};

        block[18][0] = new int[]{2,1,1,0};
        block[18][1] = new int[]{0,0,1,1};

        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){


                for(int i = 0; i< 19; i++){
                    int num = 0;
                    for(int j = 0; j< 4 ; j++) {
                        int dx = block[i][0][j];
                        int dy = block[i][1][j];
                        if (x + dx >= n || y + dy >= m) {
                            break;
                        }
                        num += map[x + dx][y + dy];
                        if(j == 3){
                            answer = Math.max(answer, num);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
