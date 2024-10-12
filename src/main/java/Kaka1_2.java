public class Kaka1_2 {

    public static void main(String[] args) {

        int n = 8;

        int[] arr = {4,2,7,3,1,8,6,5};
        int[] answer = new int[n];

        int round = 0;
        while(true){
            round++;
            n /= 2;
            if(n == 1){
                break;
            }
        }

        n = arr.length;

        for(int i = 0 ; i < round; i++){
            int j = 0;
            while(true){
                if(arr[j] != i){
                    j++;
                }
            }
        }

    }


}
