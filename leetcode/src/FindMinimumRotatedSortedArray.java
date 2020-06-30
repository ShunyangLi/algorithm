public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
//        int num = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            if (num > nums[i]) return nums[i];
//            else num = nums[i];
//        }
//
//
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i-1] > nums[i]) return nums[i];
        }

        return nums[0];
    }

    public static void main(String[] args) {

    }
}
