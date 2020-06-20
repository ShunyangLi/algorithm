import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] temp_char = str.toCharArray();
            Arrays.sort(temp_char);
            String key = Arrays.toString(temp_char).toString();
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(str);
            } else {
                List<String> temp = new LinkedList<>();
                temp.add(str);
                hashMap.put(key, temp);
            }
        }

        for (String key : hashMap.keySet()) {
            list.add(hashMap.get(key));
        }
        return list;
    }


    public static void main(String[] args) {
        String[] strs = new String[] {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(strs);
    }
}
