public class Unsorted {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        int left = -1;
        int right = -1;

        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < nums[i-1]) {
                if (left == -1) {
                    left = i - 1;
                    right = i;
                }
                else right = i;
            } else if (nums[i] == nums[i-1] && nums[i] < nums[i-1]) {
                if (left != -1) right = i;
            }
        }
        if (left == -1) return 0;
        return right - left + 1;
    }

    public static void main(String[] args) {
        Unsorted u = new Unsorted();
        int[] nums = new int[] {2,6,4,8,10,9,15};

        System.out.println(u.findUnsortedSubarray(nums));
    }
}
