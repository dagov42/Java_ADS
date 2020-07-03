package geekbrains.HomeTask_3;

public class Flip {
    public static void main(String[] args) {
        System.out.println(reverse("Hello, World"));
    }

    public static String reverse(String s) {
        String result = "";
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()) {
            result = result.concat(String.valueOf((char) stack.pop()));
        }
        return result;
    }
}
