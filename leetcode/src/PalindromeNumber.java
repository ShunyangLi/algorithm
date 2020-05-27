public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reverse = 0, temp = x;

        while (temp != 0) {
            int last_digit = temp % 10;
            reverse = reverse * 10 + last_digit;
            temp = temp / 10;
        }

        return reverse == x;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();

        System.out.println(pn.isPalindrome(121));
    }
}
