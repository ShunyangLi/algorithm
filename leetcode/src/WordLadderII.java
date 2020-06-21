import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<List<String>>();

        HashSet<String> s = new HashSet<>();
        HashSet<String> e = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        HashMap<String, HashSet<String>> maps = new HashMap<String, HashSet<String>>();

        s.add(beginWord); e.add(endWord);
        boolean forward = true;
        boolean found = false;

        while (!s.isEmpty() && !e.isEmpty()) {
            if (s.size() > e.size()) {
                HashSet<String> temp = s;
                s = e;
                e = temp;
                forward = ! forward;
            }

            HashSet<String> temp = new HashSet<>();
            visited.addAll(s);
            for (String str : s) {
                for (int i = 0; i < str.length(); i ++) {
                    char[] chars = str.toCharArray();
                    char ch = chars[i];
                    for (char j = 'a'; j <= 'z'; j ++) {
                        if (j == ch) continue;
                        chars[i] = j;
                        String t = new String(chars);
                        if (e.contains(t)) found = true;
                        if (!wordList.contains(t)) continue;
                        if (visited.contains(t)) continue;

                        String key = forward ? str : t;
                        String val = forward ? t : str;

                        HashSet<String> list = maps.containsKey(key) ? maps.get(key) : new HashSet<String>();
                        list.add(val);
                        maps.put(key, list);


                        temp.add(t);
                    }
                }
            }
            s = temp;

            if (found) {
                List<String> t = new LinkedList<>();
                t.add(endWord);
                res.add(t);
            }
        }


        return res;
    }
}
