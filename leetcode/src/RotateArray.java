import java.util.Arrays;

/**
 * 这个想法是在leetcode那边看到的，其工作原理就是先reverse一下
 * 然后在对前k个进行reverse，然后对k-len再reverse
 * 这样就能得到结果了
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || k < 1) return;
        // 整体反转
        reverse(0, nums.length - 1, nums);

        reverse(0, k % nums.length - 1, nums);
        reverse(k % nums.length, nums.length - 1, nums);
    }

    public void reverse(int left, int right, int[] nums) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        RotateArray re = new RotateArray();
        int[] nums = new int[] {1,2};
        re.rotate(nums, 1);

        System.out.println(Arrays.toString(nums));
    }
}
