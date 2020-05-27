import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');

        for (int i = 0; i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                if (!map.get(stack.pop()).equals(s.charAt(i))) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([)]"));
    }
}
