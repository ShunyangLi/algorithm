import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 0;
        if (!wordList.contains(endWord)) return step;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            ++step;
            for (int x = 0; x < queue.size(); x ++) {
                String str = queue.poll();
                visited.add(str);
                if (str.equals(endWord)) return step;
                for (int i = 0; i < str.length(); i ++) {
                    char[] temp = str.toCharArray();
                    char ch = temp[i];
                    for (char c = 'a'; c <= 'z'; c ++) {
                        if (c == ch) continue;
                        temp[i] = c;
                        String t = new String(temp);
                        if (!wordList.contains(t)) continue;
                        if (visited.contains(t)) continue;
                        queue.offer(t);
                        visited.add(t);
                    }
                }
            }
        }
        return step;
    }


    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        List<String> list = new ArrayList<String>(
                Arrays.asList("hot","dot","dog","lot","log","cog")
        );

        int res = w.ladderLength("hit", "cog", list);

        System.out.println(res);

    }
}
