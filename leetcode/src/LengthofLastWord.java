public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s.equals("")) return 0;
        String[] res = s.split(" ");

        if (res.length == 0) return 0;
        return res[res.length - 1].length();
    }

    public static void main(String[] args) {
        String r = "Hello world";

        LengthofLastWord l = new LengthofLastWord();
        System.out.println(l.lengthOfLastWord(r));
    }
}
