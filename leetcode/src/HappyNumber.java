import java.util.LinkedList;
import java.util.List;

public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int sum = n;
        List<Integer> list = new LinkedList<>();

        while (true) {
            list = split(sum);
            sum = 0;
            for (Integer i : list) {
                sum += Math.pow(i, 2);
            }

            if (sum == 1 || sum == 7) {
                return true;
            }

            if (sum < 10) return false;

        }
    }

    public List<Integer> split(int n) {
        List<Integer> list = new LinkedList<>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }
        return list;
    }

    public static void main(String[] args) {
        HappyNumber hp = new HappyNumber();
        System.out.println(hp.isHappy(19));
    }
}
