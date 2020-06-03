public class MaximumSubarray {
//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//        int[] temp = new int[2];
//        temp[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i ++) {
//            if (temp[(i - 1) % 2] >= 0) {
//                temp[i % 2] = temp[(i-1) % 2] + nums[i];
//                max = Math.max(temp[i%2], max);
//            } else {
//                temp[i % 2] = nums[i];
//            }
//        }
//
//        return max;
//    }

public int maxSubArray(int[] nums) {
    int max = nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];

    for (int i = 1; i < nums.length; i ++) {
        if (dp[i-1] < 0) {
            dp[i] = nums[i];
        } else {
            dp[i] = dp[i-1] + nums[i];
        }
        max = Math.max(dp[i], max);
    }
    return max;
}

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] array = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(ms.maxSubArray(array));
    }1
}
