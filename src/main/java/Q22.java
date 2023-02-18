import java.util.*;

class Q22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] arr = line.split("");
        int count = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("=")) {
                    if (arr[i - 1].equals("c") || arr[i - 1].equals("s")) {
                        arr[i] = null;
                        arr[i - 1] = null;
                        print(arr);
                        count++;
                    } else if ((arr[i - 1].equals("z")) && (arr[i - 2].equals("d"))) {
                        arr[i] = null;
                        arr[i - 1] = null;
                        arr[i - 2] = null;
                        print(arr);
                        count++;
                    } else if ((arr[i - 1].equals("z")) && ((!arr[i - 2].equals("d"))||(arr[i-2] == null))) {
                        arr[i] = null;
                        arr[i - 1] = null;
                        print(arr);
                        count++;
                    }
                } else if (arr[i].equals("-")) {
                    arr[i] = null;
                    arr[i - 1] = null;
                    print(arr);
                    count++;
                } else if (arr[i].equals("j")) {
                    if (arr[i - 1].equals("l") || arr[i - 1].equals("n")) {
                        arr[i] = null;
                        arr[i - 1] = null;
                        print(arr);
                        count++;
                    }
                }
            }
        }catch (Exception e) {}
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void print(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}