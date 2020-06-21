public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int num = nums[0];
        int mid = -1;

        for (int i = 1; i < nums.length; i ++) {
            if (num <= nums[i]) num = nums[i];
            else {
                mid = i - 1;
                break;
            }
        }

        if (mid == -1) mid = nums.length - 1;
        right = mid;
        while (left <= right) {
            int temp_mid = left + (right - left) / 2;
            if (nums[temp_mid] == target) return temp_mid;
            else if (nums[temp_mid] > target) {
                right = temp_mid - 1;
            } else {
                left = temp_mid + 1;
            }
        }
        left = mid + 1; right = nums.length - 1;
        while (left <= right) {
            int temp_mid = left + (right - left) / 2;
            if (nums[temp_mid] == target) return temp_mid;
            else if (nums[temp_mid] > target) {
                right = temp_mid - 1;
            } else {
                left = temp_mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        SearchRotatedArray s = new SearchRotatedArray();
        int x = s.search(nums, 3);
        System.out.println(x);
    }
}
