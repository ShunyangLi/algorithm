import java.util.Arrays;

public class Duplicate {

    public boolean duplicate(int [] numbers, int length, int duplication []) {
        Arrays.sort(numbers);
        int num = numbers[0];

        for (int i = 1; i < length; i ++) {
            if (num != numbers[i]) {
                num = numbers[i];
            } else {
                duplication[0] = num;
                break;
            }
        }

        return duplication[0] == num;
    }

    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        int[] dup = new int[]{0};
        System.out.println(duplicate.duplicate(new int[]{2,3,1,0,2,5,3}, 7, dup));
    }
}
