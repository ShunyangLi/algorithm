public class StringtoInteger {
    public int myAtoi(String str) {
        int res = 0;
        // + or -
        int operation = 1;
        if (str.equals(""))return 0;
        boolean whitespace = true;
        boolean sign = true;

        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (whitespace && c == ' ') continue;
            if (!whitespace && c == ' ') break;
            if ((c == '-' || c == '+') && sign) {
                operation = (c == '-')?-1:1;
                sign = false;
                whitespace=false;
                continue;
            }
            if (c < '0' || c > '9') break;
            whitespace = false;
            sign=false;
            if (res*operation > Integer.MAX_VALUE/10 || res*operation < Integer.MIN_VALUE/10) {
                if (operation > 0) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }

            if (res*operation == Integer.MAX_VALUE/10) if ((int)c-48 >= Integer.MAX_VALUE %10) return Integer.MAX_VALUE;
            if (res*operation == Integer.MIN_VALUE/10) if ((int)(c-48) * -1 <= Integer.MIN_VALUE % 10) return Integer.MIN_VALUE;
            res = res * 10 + (int) c - 48;
        }
        res *= operation;
        return res;
    }

    public static void main(String[] args) {
        StringtoInteger s = new StringtoInteger();
        System.out.println(s.myAtoi("-   234"));
    }
}
