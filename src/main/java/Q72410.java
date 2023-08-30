public class Q72410 {
    public static void main(String[] args) {

        String a = ".....";
        String[] str = a.split("");

        for(int i =0 ; i< str.length; i++){
            if(str[i].equals(".")){
                System.out.println(i);
            }
        }



    }
}
