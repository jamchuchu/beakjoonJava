import java.util.ArrayDeque;

public class kaka1 {
    public static void main(String[] args){
        int n = 8;

        int[] arr = {4,2,7,3,1,8,6,5};
        int[] answer = new int[n];

        ArrayDeque<int[]> deq = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            deq.add(new int[]{arr[i], i});
        }

        ArrayDeque<int[]> winner = new ArrayDeque<>();

        int round = 1;
        while(true){
            while(deq.size() > 1) {
                int[] a = deq.pollFirst();
                int[] b = deq.pollFirst();
                if (a[0] > b[0]) {
                    winner.add(a);
                    answer[b[1]] = round;
                } else {
                    winner.add(b);
                    answer[a[1]] = round;
                }
            }

            if(winner.size() == 1){
                break;
            }
            round++;
            deq.addAll(winner);
            winner = new ArrayDeque<>();
        }

        answer[winner.poll()[1]]  = round;


        for(int i : answer){
            System.out.print(i + " ");
        }
    }

}
