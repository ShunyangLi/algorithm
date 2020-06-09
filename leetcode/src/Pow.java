public class Pow {
    public double myPow(double x, int n) {
        if (x == 0) return 0;

        double sum = 1;
        while (n > 0) {
            sum *= x;
            n --;
        }

        if (sum >= Integer.MAX_VALUE) return (double) Math.round(Integer.MAX_VALUE*100000)/100000;
        if (sum <= Integer.MIN_VALUE) return (double) Math.round(Integer.MIN_VALUE*100000)/100000;


        return (double) Math.round(sum);
    }

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2.1, 3));
    }
}
