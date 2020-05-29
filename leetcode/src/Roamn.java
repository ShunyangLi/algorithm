import java.util.HashMap;
import java.util.Map;

public class Roamn {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == 'V' || c == 'X') {
                if (i > 0) {
                    if (s.charAt(i-1) == 'I') res += map.get(c) - 2;
                    else res += map.get(c);
                } else res += map.get(c);
            } else if (c == 'L' || c == 'C') {
                if (i > 0) {
                    if (s.charAt(i-1) == 'X') res += map.get(c) - 20;
                    else res += map.get(c);
                } else res += map.get(c);
            } else if (c == 'D' || c == 'M') {
                if (i > 0) {
                    if (s.charAt(i-1) == 'C') res += map.get(c) - 200;
                    else res += map.get(c);
                } else res += map.get(c);
            } else {
                res += map.get(c);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Roamn r = new Roamn();
        System.out.println(r.romanToInt("MCMXCIV"));
    }
}
