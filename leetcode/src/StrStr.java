import java.util.Arrays;

public class StrStr {
//    public int strStr(String haystack, String needle) {
//        if (needle.length() == 0) return 0;
//        char c = needle.charAt(0);
//        for (int i = 0; i < haystack.length(); i ++) {
//            if (haystack.charAt(i) == c) {
//                if (i + needle.length() > haystack.length()) return -1;
//                if (haystack.substring(i, i+needle.length()).equals(needle)) return i;
//            }
//        }
//        return -1;
//    }

    public int[] prefix(String str) {
        int[] prefix = new int[str.length()];

        // 左右最长公共后缀, 左右两边肯定相等的
        prefix[0] = 0;
        int len = 0;
        int i = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len ++;
                prefix[i] = len;
                i ++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = len;
                    i ++;
                }
            }
        }
        move(prefix);
        return prefix;
    }

    public void move(int[] prefix) {
        if (prefix.length - 1 >= 0) System.arraycopy(prefix, 0, prefix, 1, prefix.length - 1);
        prefix[0] = -1;
    }

    // nm用的时间更长了....
    public int strStr (String text, String match) {
        if (text.equals(match)) return 0;
        if (text.length() == 0) return -1;
        if (match.length() == 0) return 0;

        int[] prefix = prefix(match);
        System.out.println(Arrays.toString(prefix));

        // text lens n index i
        // prefix len m index j
        int i = 0;
        int j = 0;
        while ( i < text.length()) {
            if (j == match.length() - 1 && text.charAt(i) == match.charAt(j)) {
                return i - j;
            }
            if (text.charAt(i) == match.charAt(j)) {
                i ++;
                j ++;
            } else {
                j = prefix[j];
                if (j == -1) {
                    j ++;
                    i ++;
                }
            }
        }

        return -1;
    }
}
