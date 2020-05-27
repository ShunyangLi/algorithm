public class ReverseInteger {
    public int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            int last_digit = x % 10;
            if (reverse > Integer.MAX_VALUE / 10) return 0;
            if (reverse < Integer.MIN_VALUE / 10) return 0;
            reverse = reverse * 10 + last_digit;
            x = x / 10;
        }

        return reverse ;
    }

    public static void main(String[] args) {
        ReverseInteger re = new ReverseInteger();
        System.out.println(re.reverse(1534236469));
    }
}
