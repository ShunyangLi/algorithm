import java.util.*;

public class LetterCombinationsofaPhoneNumber {

    private List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        if (digits == null || digits.length() == 0) return result;

        HashMap<Character, String> maps = new HashMap<>();
        maps.put('2', "abc");
        maps.put('3', "def");
        maps.put('4', "ghi");
        maps.put('5', "jkl");
        maps.put('6', "mno");
        maps.put('7', "pqrs");
        maps.put('8', "tuv");
        maps.put('9', "wyxz");

        dfs(digits, 0, "", result, maps);

        return result;
    }

    public void dfs(String digits, int index, String temp, List<String> res, HashMap<Character, String> maps) {
        if (index == digits.length()) {
            res.add(temp);
            return;
        }

        String t = maps.get(digits.charAt(index));

        for (int i = 0; i < t.length(); i ++) {
            dfs(digits, index + 1, temp + t.charAt(i), res, maps);
        }

    }

//    private List<String> letterCombinations(String digits) {
//        List<String> result = new LinkedList<>();
//        HashMap<Character, String> maps = new HashMap<>();
//        maps.put('2', "abc");
//        maps.put('3', "def");
//        maps.put('4', "ghi");
//        maps.put('5', "jkl");
//        maps.put('6', "mno");
//        maps.put('7', "pqrs");
//        maps.put('8', "tuv");
//        maps.put('9', "wyxz");
//
//        // 先实验一下相乘的办法，因为还有很多好的办法，一会慢慢看
//
//        for (int i = 0; i < digits.length(); i ++) {
//            if (!maps.containsKey(digits.charAt(i))) continue;
//
//            String str = maps.get(digits.charAt(i));
//            result = mul(result, new ArrayList<>(Arrays.asList(str.split(""))));
//        }
//
//        return result;
//    }
//
//
//
//    private List<String> mul(List<String> s1, List<String> s2) {
//        if (s1.size() == 0 && s2.size() != 0) {
//            return s2;
//        }
//
//        if (s1.size() != 0 && s2.size() == 0) {
//            return s1;
//        }
//
//        List<String> result = new LinkedList<>();
//        for (String value : s1) {
//            for (String s : s2) {
//                result.add(value + s);
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        String str = "234";

        List<String> res = l.letterCombinations(str);

        for (String s : res) {
            System.out.println(s);
        }
    }
}
