import java.util.Arrays;
import java.util.stream.IntStream;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int lens = digits.length - 1;
        int[] nums = digits.clone();
        int overflow = 0;
        nums[lens] += 1;

        while (lens != -1) {
            // every time plus one
            nums[lens] += overflow;
            overflow = nums[lens] / 10;
            if (nums[lens] > 9) nums[lens] %= 10;
            lens --;
            // 当不溢出的时候就可以break了，因为不会进位了
            if (overflow == 0) break;
        }

        // 如果循环结束还溢出，说明还需要多开辟一个内存位置。
        if (overflow != 0) {
            nums = IntStream.concat(Arrays.stream(new int[] {1}), Arrays.stream(nums)).toArray();
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {8,9};
        PlusOne p = new PlusOne();
        int[] res = p.plusOne(nums);
        System.out.println(Arrays.toString(res));
    }
}
