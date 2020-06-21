import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            hash(str);
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

    public void hash(String str) {
        int hash = 31;
        for (int i = 0; i < str.length(); i ++) {
            hash += str.charAt(i);
        }
        System.out.println(hash);
    }


    public static void main(String[] args) {
        String[] strs = new String[] {"duy","ill"};
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(strs);
    }
}
