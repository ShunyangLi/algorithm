import java.util.Collections;
import java.util.HashMap;

public class FirstUnique {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
            } else {
                map.put(c, i);
            }
        }

        int position = Integer.MAX_VALUE;
        for (Character c : map.keySet()) {
            if (map.get(c) != Integer.MAX_VALUE) {
                if (map.get(c) < position) position = map.get(c);
            }
        }
        if (position == Integer.MAX_VALUE) return -1;
        return position;
    }

    public static void main(String[] args) {
        FirstUnique f = new FirstUnique();
        String str = "loveleetcode";
        System.out.println(f.firstUniqChar(str));
    }
}
