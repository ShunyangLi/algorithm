public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int one = con(nums, 0);
        int two = con(nums, 1);

        return Math.max(one, two);
    }

    public int con(int[] nums, int index) {
        if (index > nums.length - 1) return 0;

        int num = con(nums, index + 2);
        return nums[index] + num;
    }

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[] nums = new int[] {1, 2};
        int one = h.con(nums, 0);
        int two = h.con(nums, 1);

        System.out.println(one);
        System.out.println(two);
    }
}
