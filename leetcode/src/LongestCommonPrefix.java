public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int min = Integer.MAX_VALUE;
        int index = -1;

        // get the shortest string length
        for (int i = 0; i < strs.length; i ++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                index = i;
            }
        }

        for (int i  = 0; i < min; i ++) {
            char c = strs[0].charAt(i);

            for (String str : strs) {
                if (c != str.charAt(i)) return str.substring(0, i);
            }
        }

        return strs[index];

//        for (int i = 0; i < strs[0].length(); i ++ ) {
//            char c = strs[0].charAt(i);
//
//            for (int j = 1; j < strs.length; j ++) {
//                if (i == strs[j].length() || c != strs[j].charAt(i))
//                    return strs[0].substring(0, i);
//            }
//        }
//        return strs[0];
    }



}
