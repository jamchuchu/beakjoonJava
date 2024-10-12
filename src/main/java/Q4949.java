import java.io.*;
import java.util.ArrayDeque;

public class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = reader.readLine();
            if (str.equals(".")) {
                break;
            }
            writer.write(isBalanced(str) ? "yes\n" : "no\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    static boolean isBalanced(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.addFirst(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.poll();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}