import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int remove = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length();) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
                ans = Math.max(map.size(), ans);
                i ++;
            } else {
                map.remove(s.charAt(remove));
                remove += 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        LongestSubstring lon = new LongestSubstring();
        System.out.println(lon.lengthOfLongestSubstring("abcabcbb"));
    }
}
